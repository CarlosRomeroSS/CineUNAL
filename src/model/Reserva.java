public class Reserva {
    private Integer id;
    private Cliente cliente;
    private Funcion funcion;
    private List<Asiento> asientos;
    private LocalDateTime fechaReserva;
    private BigDecimal total;
    
    // Constructor
    public Reserva(Integer id, Cliente cliente, Funcion funcion) {
        this.id = id;
        this.cliente = cliente;
        this.funcion = funcion;
        this.asientos = new ArrayList<>();
        this.fechaReserva = LocalDateTime.now();
        this.total = BigDecimal.ZERO;
    }
    
    // Getters y Setters
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
    
    // Método específico del diagrama
    public BoletoDigital confirmar() {
        // Marcar asientos como reservados
        for (Asiento asiento : asientos) {
            asiento.reservar();
        }
        
        // Crear boleto digital
        BoletoDigital boleto = new BoletoDigital();
        boleto.setReserva(this);
        
        return boleto;
    }
    
    // Método específico del diagrama
    public BigDecimal calcularTotal() {
        // Usar PriceCalculator para calcular el precio
        PriceCalculator calculator = new PriceCalculator();
        this.total = calculator.calcularPrecio(this);
        return this.total;
    }
}
