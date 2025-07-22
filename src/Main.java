public class Main {
    public static void main(String[] args) {
        System.out.println("¡Bienvenido a CineUNAL!");
    
    //toca inicializar las salas que ya deberiamos tener pensada

    }
}
import java.time.DateTime;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.math.BigDecimal;

// Pelicula.java
public class Pelicula {
    private Integer id;
    private String titulo;
    private String genero;
    private Integer duracion;
    private String clasificacion;
    private String sinopsis;
    private String director;
    private List<String> reparto;
    
    // Constructor
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
    
    // Getters y Setters
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
    
    // Método específico del diagrama
    public String getDetalle() {
        return "Película: " + titulo + "\n" +
               "Género: " + genero + "\n" +
               "Duración: " + duracion + " minutos\n" +
               "Director: " + director + "\n" +
               "Clasificación: " + clasificacion + "\n" +
               "Sinopsis: " + sinopsis;
    }
}

// Asiento.java
public class Asiento {
    private Integer id;
    private String fila;
    private Integer numero;
    private AsientoEstado estado;
    
    // Constructor
    public Asiento(Integer id, String fila, Integer numero) {
        this.id = id;
        this.fila = fila;
        this.numero = numero;
        this.estado = AsientoEstado.DISPONIBLE;
    }
    
    // Getters y Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    
    public String getFila() { return fila; }
    public void setFila(String fila) { this.fila = fila; }
    
    public Integer getNumero() { return numero; }
    public void setNumero(Integer numero) { this.numero = numero; }
    
    public AsientoEstado getEstado() { return estado; }
    public void setEstado(AsientoEstado estado) { this.estado = estado; }
    
    // Métodos específicos del diagrama
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

// Sala.java
public class Sala {
    private Integer id;
    private String nombre;
    private SalaTipo tipo;
    private Integer capacidad;
    private Map<Integer, Asiento> distribucion;
    
    // Constructor
    public Sala(Integer id, String nombre, SalaTipo tipo, Integer capacidad) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.capacidad = capacidad;
        this.distribucion = new HashMap<>();
    }
    
    // Getters y Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public SalaTipo getTipo() { return tipo; }
    public void setTipo(SalaTipo tipo) { this.tipo = tipo; }
    
    public Integer getCapacidad() { return capacidad; }
    public void setCapacidad(Integer capacidad) { this.capacidad = capacidad; }
    
    public Map<Integer, Asiento> getDistribucion() { return distribucion; }
    public void setDistribucion(Map<Integer, Asiento> distribucion) { this.distribucion = distribucion; }
    
    // Método específico del diagrama
    public void configurarSala() {
        // Configurar asientos según el tipo de sala
        distribucion.clear();
        
        String[] filas = {"A", "B", "C", "D", "E", "F", "G", "H"};
        int asientosPorFila = capacidad / filas.length;
        int asientoId = 1;
        
        for (String fila : filas) {
            for (int num = 1; num <= asientosPorFila; num++) {
                Asiento asiento = new Asiento(asientoId, fila, num);
                distribucion.put(asientoId, asiento);
                asientoId++;
            }
        }
    }
}

// Cliente.java
public class Cliente {
    private Integer id;
    private String nombre;
    private String email;
    private ClienteTipo tipoCliente;
    
    // Constructor
    public Cliente(Integer id, String nombre, String email, ClienteTipo tipoCliente) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.tipoCliente = tipoCliente;
    }
    
    // Getters y Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public ClienteTipo getTipoCliente() { return tipoCliente; }
    public void setTipoCliente(ClienteTipo tipoCliente) { this.tipoCliente = tipoCliente; }
    
    // Método específico del diagrama
    public Reserva crearReserva() {
        // Este método se implementará cuando tengamos la clase Reserva
        return null;
    }
}

// Funcion.java
public class Funcion {
    private Integer id;
    private LocalDateTime fechaHora;
    private Sala sala;
    private Pelicula pelicula;
    private String tipoVersion;
    
    // Constructor
    public Funcion(Integer id, LocalDateTime fechaHora, Sala sala, Pelicula pelicula, String tipoVersion) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.sala = sala;
        this.pelicula = pelicula;
        this.tipoVersion = tipoVersion;
    }
    
    // Getters y Setters
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
    
    // Método específico del diagrama
    public Map<Asiento, AsientoEstado> mostrarDisponibilidad() {
        Map<Asiento, AsientoEstado> disponibilidad = new HashMap<>();
        
        for (Asiento asiento : sala.getDistribucion().values()) {
            disponibilidad.put(asiento, asiento.getEstado());
        }
        
        return disponibilidad;
    }
}

// Reserva.java
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
