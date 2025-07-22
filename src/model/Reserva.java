import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.math.BigDecimal;
public class Reserva {
    private Integer id;
    private Cliente cliente;
    private Funcion funcion;
    private List<Asiento> asientos;
    private LocalDateTime fechaReserva;
    private BigDecimal total;
    
    public Reserva(Integer id, Cliente cliente, Funcion funcion) {
        this.id = id;
        this.cliente = cliente;
        this.funcion = funcion;
        this.asientos = new ArrayList<>();
        this.fechaReserva = LocalDateTime.now();
        this.total = BigDecimal.ZERO;
    }
    
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    
    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
    
    public Funcion getFuncion() { return funcion; }
    public void setFuncion(Funcion funcion) { this.funcion = funcion; }
    
    public List<Asiento> getAsientos() { return asientos; }
    public void setAsientos(List<Asiento> asientos) { this.asientos = asientos; }
    
    public LocalDateTime getFechaReserva() { return fechaReserva; }
    public void setFechaReserva(LocalDateTime fechaReserva) { this.fechaReserva = fechaReserva; }
    
    public BigDecimal getTotal() { return total; }
    public void setTotal(BigDecimal total) { this.total = total; }
    
    public BoletoDigital confirmar() {
        for (Asiento asiento : asientos) {
            asiento.reservar();
        }
        
        BoletoDigital boleto = new BoletoDigital();
        boleto.setReserva(this);
        
        return boleto;
    }
    
    public BigDecimal calcularTotal() {
        PriceCalculator calculator = new PriceCalculator();
        this.total = calculator.calcularPrecio(this);
        return this.total;
    }
}
