
import java.util.ArrayList;
import java.util.List;
public class Administrador {
    private List<Pelicula> peliculas;
    private List<Sala> salas;
    private List<Funcion> funciones;
    
    public Administrador() {
        this.peliculas = new ArrayList<>();
        this.salas = new ArrayList<>();
        this.funciones = new ArrayList<>();
    }
    
    public List<Pelicula> getPeliculas() { return peliculas; }
    public List<Sala> getSalas() { return salas; }
    public List<Funcion> getFunciones() { return funciones; }
    
    public void agregarPelicula(Pelicula pelicula) {
        if (pelicula != null && !peliculas.contains(pelicula)) {
            peliculas.add(pelicula);
            System.out.println("Película agregada: " + pelicula.getTitulo());
        }
    }
    public void modificarPelicula(Pelicula pelicula) {
        if (pelicula != null && peliculas.contains(pelicula)) {
            System.out.println("Película modificada: " + pelicula.getTitulo());
        } else {
            System.out.println("Película no encontrada para modificar");
        }
    }
    public void configurarFuncion(Funcion funcion) {
        if (funcion != null && !funciones.contains(funcion)) {
            if (peliculas.contains(funcion.getPelicula()) && 
                salas.contains(funcion.getSala())) {
                funciones.add(funcion);
                System.out.println("Función configurada: " + 
                    funcion.getPelicula().getTitulo() + " en " + 
                    funcion.getSala().getNombre());
            } else {
                System.out.println("Error: Película o sala no encontrada");
            }
        }
    }
    public void agregarSala(Sala sala) {
        if (sala != null && !salas.contains(sala)) {
            salas.add(sala);
            System.out.println("Sala agregada: " + sala.getNombre());
        }
    }
    
    public Pelicula buscarPeliculaPorId(Integer id) {
        return peliculas.stream()
            .filter(p -> p.getId().equals(id))
            .findFirst()
            .orElse(null);
    }
    
    public Sala buscarSalaPorId(Integer id) {
        return salas.stream()
            .filter(s -> s.getId().equals(id))
            .findFirst()
            .orElse(null);
    }
    
    public List<Funcion> buscarFuncionesPorPelicula(Pelicula pelicula) {
        return funciones.stream()
            .filter(f -> f.getPelicula().equals(pelicula))
            .collect(java.util.stream.Collectors.toList());
    }
}