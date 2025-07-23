import java.time.LocalDateTime;
import java.util.*;
import model.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Administrador admin = new Administrador();

        while (true) {
            System.out.println("\n--- Menú CineUNAL ---");
            System.out.println("1. Agregar película");
            System.out.println("2. Agregar sala");
            System.out.println("3. Agregar función");
            System.out.println("4. Reservar");
            System.out.println("5. Salir");
            System.out.print("Seleccione opción: ");
            int opcion = sc.nextInt();
            sc.nextLine();

            if (opcion == 1) {
                System.out.print("Título: ");
                String titulo = sc.nextLine();
                System.out.print("Género: ");
                String genero = sc.nextLine();
                System.out.print("Duración (min): ");
                int duracion = sc.nextInt(); sc.nextLine();
                System.out.print("Clasificación: ");
                String clasificacion = sc.nextLine();
                System.out.print("Sinopsis: ");
                String sinopsis = sc.nextLine();
                System.out.print("Director: ");
                String director = sc.nextLine();
                Pelicula pelicula = new Pelicula(admin.getPeliculas().size()+1, titulo, genero, duracion, clasificacion, sinopsis, director);
                admin.agregarPelicula(pelicula);
            } else if (opcion == 2) {
                System.out.print("Nombre sala: ");
                String nombre = sc.nextLine();
                System.out.print("Tipo (ESTANDAR, VIP, TRESD, IMAX): ");
                String tipo = sc.nextLine();
                System.out.print("Capacidad: ");
                int capacidad = sc.nextInt(); sc.nextLine();
                Sala sala = new Sala(admin.getSalas().size()+1, nombre, SalaTipo.valueOf(tipo), capacidad);
                sala.configurarSala();
                admin.agregarSala(sala);
            } else if (opcion == 3) {
                System.out.println("Películas disponibles:");
                for (Pelicula p : admin.getPeliculas()) System.out.println(p.getId() + ". " + p.getTitulo());
                System.out.print("ID película: ");
                int idP = sc.nextInt(); sc.nextLine();
                Pelicula pelicula = admin.getPeliculas().stream().filter(p -> p.getId() == idP).findFirst().orElse(null);

                System.out.println("Salas disponibles:");
                for (Sala s : admin.getSalas()) System.out.println(s.getId() + ". " + s.getNombre());
                System.out.print("ID sala: ");
                int idS = sc.nextInt(); sc.nextLine();
                Sala sala = admin.getSalas().stream().filter(s -> s.getId() == idS).findFirst().orElse(null);

                System.out.print("Formato (2D/3D): ");
                String formato = sc.nextLine();
                System.out.print("Días desde hoy: ");
                int dias = sc.nextInt(); sc.nextLine();
                Funcion funcion = new Funcion(admin.getFunciones().size()+1, LocalDateTime.now().plusDays(dias), sala, pelicula, formato);
                admin.configurarFuncion(funcion);
            } else if (opcion == 4) {
                // Reservar
                System.out.println("Funciones disponibles:");
                for (Funcion f : admin.getFunciones()) {
                    System.out.println(f.getId() + ". " + f.getPelicula().getTitulo() + " en " + f.getSala().getNombre() + " (" + f.getFormato() + ")");
                }
                System.out.print("ID función: ");
                int idF = sc.nextInt(); sc.nextLine();
                Funcion funcion = admin.getFunciones().stream().filter(f -> f.getId() == idF).findFirst().orElse(null);

                System.out.print("Nombre cliente: ");
                String nombre = sc.nextLine();
                System.out.print("Email cliente: ");
                String email = sc.nextLine();
                System.out.print("Tipo (GENERAL, ESTUDIANTE, TERCERA_EDAD, NIÑO): ");
                String tipo = sc.nextLine();
                
                Cliente cliente = new Cliente(
                    admin.getPeliculas().size()+1,
                    nombre,
                    email,
                    ClienteTipo.valueOf(tipo.trim().toUpperCase())
                );

                // Selección de asientos
                List<Asiento> disponibles = new ArrayList<>();
                for (Asiento a : funcion.getSala().getDistribucion().values()) {
                    if (a.getEstado() == AsientoEstado.DISPONIBLE) disponibles.add(a);
                }
                System.out.println("Asientos disponibles:");
                for (Asiento a : disponibles) System.out.println(a.getId() + ": " + a);
                System.out.print("IDs de asientos (separados por coma): ");
                String[] ids = sc.nextLine().split(",");
                List<Asiento> seleccionados = new ArrayList<>();
                for (String id : ids) {
                    int aid = Integer.parseInt(id.trim());
                    Asiento asiento = funcion.getSala().getDistribucion().get(aid);
                    if (asiento != null && asiento.getEstado() == AsientoEstado.DISPONIBLE) {
                        seleccionados.add(asiento);
                        asiento.reservar();
                    }
                }

                Reserva reserva = new Reserva(admin.getFunciones().size()+1, cliente, funcion);
                reserva.setAsientos(seleccionados);
                reserva.calcularTotal();
                BoletoDigital boleto = reserva.confirmar();

                System.out.println("\n--- RESERVA CONFIRMADA ---");
                System.out.println(boleto.generarPDF());
            } else if (opcion == 5) {
                System.out.println("¡Hasta luego!");
                break;
            }
        }
        sc.close();
    }
}