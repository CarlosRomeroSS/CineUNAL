package model;
public class Asiento {
    private Integer id;
    private String fila;
    private Integer numero;
    private AsientoEstado estado;
    
    public Asiento(Integer id, String fila, Integer numero) {
        this.id = id;
        this.fila = fila;
        this.numero = numero;
        this.estado = AsientoEstado.DISPONIBLE;
    }
    
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    
    public String getFila() { return fila; }
    public void setFila(String fila) { this.fila = fila; }
    
    public Integer getNumero() { return numero; }
    public void setNumero(Integer numero) { this.numero = numero; }
    
    public AsientoEstado getEstado() { return estado; }
    public void setEstado(AsientoEstado estado) { this.estado = estado; }
    
    public void reservar() {
        this.estado = AsientoEstado.RESERVADO;
    }
    
    public void liberar() {
        this.estado = AsientoEstado.DISPONIBLE;
    }
    
    @Override
    public String toString() {
        return fila + numero + " (" + estado + ")";
    }
}
