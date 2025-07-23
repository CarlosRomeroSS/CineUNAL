package model;
public class Cliente {
    private Integer id;
    private String nombre;
    private String email;
    private ClienteTipo tipoCliente;
    public Cliente(Integer id, String nombre, String email, ClienteTipo tipoCliente) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.tipoCliente = tipoCliente;
    }
    
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public ClienteTipo getTipoCliente() { return tipoCliente; }
    public void setTipoCliente(ClienteTipo tipoCliente) { this.tipoCliente = tipoCliente; }
    
    public Reserva crearReserva() {
        return null;
    }
}
