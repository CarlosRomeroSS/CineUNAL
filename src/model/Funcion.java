package model;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
public class Funcion {
    private Integer id;
    private LocalDateTime fechaHora;
    private Sala sala;
    private Pelicula pelicula;
    private String tipoVersion;
    private String formato;
    
    public Funcion(Integer id, LocalDateTime fechaHora, Sala sala, Pelicula pelicula, String tipoVersion) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.sala = sala;
        this.pelicula = pelicula;
        this.tipoVersion = tipoVersion;
    }
    
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    
    public LocalDateTime getFechaHora() { return fechaHora; }
    public void setFechaHora(LocalDateTime fechaHora) { this.fechaHora = fechaHora; }
    
    public Sala getSala() { return sala; }
    public void setSala(Sala sala) { this.sala = sala; }
    
    public Pelicula getPelicula() { return pelicula; }
    public void setPelicula(Pelicula pelicula) { this.pelicula = pelicula; }
    
    public String getTipoVersion() { return tipoVersion; }
    public void setTipoVersion(String tipoVersion) { this.tipoVersion = tipoVersion; }
    
    
    public Map<Asiento, AsientoEstado> mostrarDisponibilidad() {
        Map<Asiento, AsientoEstado> disponibilidad = new HashMap<>();
        
        for (Asiento asiento : sala.getDistribucion().values()) {
            disponibilidad.put(asiento, asiento.getEstado());
        }
        
        return disponibilidad;
    }
    
    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }
}
