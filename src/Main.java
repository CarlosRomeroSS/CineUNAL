import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import model.*;
public class Main {
    public static void main(String[] args) {
        Administrador admin = new Administrador();

        // Crear película y agregarla
        Pelicula pelicula = new Pelicula(1, "Avatar", "Ciencia Ficción", 180, 
            "PG-13", "Una historia épica...", "James Cameron");
        admin.agregarPelicula(pelicula);

        // Crear sala y configurarla
        Sala sala = new Sala(1, "Sala 1", SalaTipo.VIP, 40);
        sala.configurarSala();
        admin.agregarSala(sala);

        // Crear función y agregarla
        Funcion funcion = new Funcion(1, LocalDateTime.now().plusDays(1), sala, pelicula, "3D");
        admin.configurarFuncion(funcion);

        // Crear cliente
        Cliente cliente = new Cliente(1, "Juan Pérez", "juan@email.com", ClienteTipo.ESTUDIANTE);

        // Seleccionar asientos
        List<Asiento> asientosSeleccionados = new ArrayList<>();
        asientosSeleccionados.add(sala.getDistribucion().get(1));
        asientosSeleccionados.add(sala.getDistribucion().get(2));

        // Crear reserva
        Reserva reserva = new Reserva(1, cliente, funcion);
        reserva.setAsientos(asientosSeleccionados);

        // Calcular total y confirmar reserva
        reserva.calcularTotal();
        BoletoDigital boleto = reserva.confirmar();

        // Mostrar boleto digital
        System.out.println(boleto.generarPDF());

        System.out.println("¡Sistema funcionando!");
    }
}