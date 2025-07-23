package model;
import java.util.ArrayList;
import java.util.List;
public class Pelicula {
    private Integer id;
    private String titulo;
    private String genero;
    private Integer duracion;
    private String clasificacion;
    private String sinopsis;
    private String director;
    private List<String> reparto;
    
    public Pelicula(Integer id, String titulo, String genero, Integer duracion, 
                   String clasificacion, String sinopsis, String director) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.duracion = duracion;
        this.clasificacion = clasificacion;
        this.sinopsis = sinopsis;
        this.director = director;
        this.reparto = new ArrayList<>();
    }
    
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    
    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }
    
    public Integer getDuracion() { return duracion; }
    public void setDuracion(Integer duracion) { this.duracion = duracion; }
    
    public String getClasificacion() { return clasificacion; }
    public void setClasificacion(String clasificacion) { this.clasificacion = clasificacion; }
    
    public String getSinopsis() { return sinopsis; }
    public void setSinopsis(String sinopsis) { this.sinopsis = sinopsis; }
    
    public String getDirector() { return director; }
    public void setDirector(String director) { this.director = director; }
    
    public List<String> getReparto() { return reparto; }
    public void setReparto(List<String> reparto) { this.reparto = reparto; }
    
    public String getDetalle() {
        return "Película: " + titulo + "\n" +
               "Género: " + genero + "\n" +
               "Duración: " + duracion + " minutos\n" +
               "Director: " + director + "\n" +
               "Clasificación: " + clasificacion + "\n" +
               "Sinopsis: " + sinopsis;
    }
}

