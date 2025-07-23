package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Administrador {
    private final List<Pelicula> peliculas;
    private final List<Sala> salas;
    private final List<Funcion> funciones;
    private final List<Reserva> reservas;

    public Administrador() {
        this.peliculas = new ArrayList<>();
        this.salas = new ArrayList<>();
        this.funciones = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }

    public List<Pelicula> getPeliculas() { return peliculas; }
    public List<Sala> getSalas() { return salas; }
    public List<Funcion> getFunciones() { return funciones; }
    public List<Reserva> getReservas() { return reservas; }

    public void agregarPelicula(Pelicula pelicula) {
        if (pelicula != null && !peliculas.contains(pelicula)) {
            peliculas.add(pelicula);
            System.out.println("Película agregada: " + pelicula.getTitulo());
        }
    }

    public void agregarSala(Sala sala) {
        if (sala != null && !salas.contains(sala)) {
            salas.add(sala);
            System.out.println("Sala agregada: " + sala.getNombre());
        }
    }

    public void configurarFuncion(Funcion funcion) {
        if (funcion != null && !funciones.contains(funcion)) {
            if (peliculas.contains(funcion.getPelicula()) &&
                salas.contains(funcion.getSala())) {
                funciones.add(funcion);
                System.out.println("Función configurada: " +
                    funcion.getPelicula().getTitulo() +
                    " en " + funcion.getSala().getNombre());
            } else {
                System.out.println("Error: Película o sala no encontrada");
            }
        }
    }

    public void agregarReserva(Reserva reserva) {
        if (reserva != null && !reservas.contains(reserva)) {
            reservas.add(reserva);
            System.out.println("Reserva agregada: ID " + reserva.getId() +
                               " para " + reserva.getCliente().getNombre());
        }
    }

    public Pelicula buscarPeliculaPorId(int id) {
        return peliculas.stream()
                        .filter(p -> p.getId() == id)
                        .findFirst().orElse(null);
    }

    public Sala buscarSalaPorId(int id) {
        return salas.stream()
                    .filter(s -> s.getId() == id)
                    .findFirst().orElse(null);
    }

    public List<Funcion> buscarFuncionesPorPelicula(Pelicula pelicula) {
        return funciones.stream()
                        .filter(f -> f.getPelicula().equals(pelicula))
                        .collect(Collectors.toList());
    }

    public List<Funcion> buscarFuncionesPorSala(Sala sala) {
        return funciones.stream()
                        .filter(f -> f.getSala().equals(sala))
                        .collect(Collectors.toList());
    }

    public List<Reserva> buscarReservasPorFuncion(Funcion funcion) {
        return reservas.stream()
                       .filter(r -> r.getFuncion().equals(funcion))
                       .collect(Collectors.toList());
    }

    public void eliminarPelicula(int id) {
        Pelicula p = buscarPeliculaPorId(id);
        if (p == null) {
            System.out.println("Película no encontrada.");
            return;
        }
        if (!buscarFuncionesPorPelicula(p).isEmpty()) {
            System.out.println("No se puede eliminar. La película tiene funciones asociadas.");
            return;
        }
        peliculas.remove(p);
        System.out.println("Película eliminada: " + p.getTitulo());
    }

    public void eliminarSala(int id) {
        Sala s = buscarSalaPorId(id);
        if (s == null) {
            System.out.println("Sala no encontrada.");
            return;
        }
        if (!buscarFuncionesPorSala(s).isEmpty()) {
            System.out.println("No se puede eliminar. La sala tiene funciones asociadas.");
            return;
        }
        salas.remove(s);
        System.out.println("Sala eliminada: " + s.getNombre());
    }

    public void eliminarFuncion(int id) {
        Funcion f = funciones.stream()
                             .filter(fn -> fn.getId() == id)
                             .findFirst().orElse(null);
        if (f == null) {
            System.out.println("Función no encontrada.");
            return;
        }
        if (!buscarReservasPorFuncion(f).isEmpty()) {
            System.out.println("No se puede eliminar. La función tiene reservas asociadas.");
            return;
        }
        funciones.remove(f);
        System.out.println("Función eliminada: " +
            f.getPelicula().getTitulo() +
            " en sala " + f.getSala().getNombre());
    }

    public void eliminarReserva(int id) {
        Reserva r = reservas.stream()
                            .filter(res -> res.getId() == id)
                            .findFirst().orElse(null);
        if (r == null) {
            System.out.println("Reserva no encontrada.");
            return;
        }
        reservas.remove(r);
        System.out.println("Reserva eliminada: ID " + r.getId() +
                           " de " + r.getCliente().getNombre());
    }
}