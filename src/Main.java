import java.time.DateTime;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.math.BigDecimal;
public class Main {
    public static void main(String[] args) {
        System.out.println("¡Bienvenido a CineUNAL!");
    
    //toca inicializar las salas que ya deberiamos tener pensada
import java.math.BigDecimal;
import java.util.List;
import java.util.ArrayList;

// BoletoDigital.java
public class BoletoDigital {
    private String idQR;
    private Reserva reserva;
    private String formatoPDF;
    
    // Constructor
    public BoletoDigital() {
        this.idQR = generarQR();
        this.formatoPDF = "PDF";
    }
    
    // Getters y Setters
    public String getIdQR() { return idQR; }
    public void setIdQR(String idQR) { this.idQR = idQR; }
    
    public Reserva getReserva() { return reserva; }
    public void setReserva(Reserva reserva) { this.reserva = reserva; }
    
    public String getFormatoPDF() { return formatoPDF; }
    public void setFormatoPDF(String formatoPDF) { this.formatoPDF = formatoPDF; }
    
    // Método específico del diagrama
    public String generarPDF() {
        StringBuilder pdf = new StringBuilder();
        pdf.append("=== BOLETO DIGITAL CINE UNAL ===\n");
        pdf.append("QR: ").append(idQR).append("\n");
        pdf.append("Cliente: ").append(reserva.getCliente().getNombre()).append("\n");
        pdf.append("Película: ").append(reserva.getFuncion().getPelicula().getTitulo()).append("\n");
        pdf.append("Sala: ").append(reserva.getFuncion().getSala().getNombre()).append("\n");
        pdf.append("Fecha: ").append(reserva.getFuncion().getFechaHora()).append("\n");
        pdf.append("Asientos: ");
        
        for (Asiento asiento : reserva.getAsientos()) {
            pdf.append(asiento.getFila()).append(asiento.getNumero()).append(" ");
        }
        
        pdf.append("\nTotal: $").append(reserva.getTotal()).append("\n");
        pdf.append("===============================");
        
        return pdf.toString();
    }
    
    // Método auxiliar para generar QR
    private String generarQR() {
        return "QR" + System.currentTimeMillis();
    }
}

// PriceCalculator.java
public class PriceCalculator {
    private static final BigDecimal PRECIO_BASE = new BigDecimal("15000");
    private static final BigDecimal DESCUENTO_ESTUDIANTE = new BigDecimal("0.20");
    private static final BigDecimal DESCUENTO_TERCERA_EDAD = new BigDecimal("0.30");
    private static final BigDecimal DESCUENTO_NIÑO = new BigDecimal("0.40");
    private static final BigDecimal RECARGO_VIP = new BigDecimal("0.50");
    private static final BigDecimal RECARGO_IMAX = new BigDecimal("0.80");
    private static final BigDecimal RECARGO_TRESD = new BigDecimal("0.30");
    
    // Método específico del diagrama
    public BigDecimal calcularPrecio(Reserva reserva) {
        BigDecimal precioTotal = BigDecimal.ZERO;
        
        // Precio base por asiento
        BigDecimal precioAsiento = PRECIO_BASE;
        
        // Aplicar recargo por tipo de sala
        SalaTipo tipoSala = reserva.getFuncion().getSala().getTipo();
        switch (tipoSala) {
            case VIP:
                precioAsiento = precioAsiento.multiply(BigDecimal.ONE.add(RECARGO_VIP));
                break;
            case IMAX:
                precioAsiento = precioAsiento.multiply(BigDecimal.ONE.add(RECARGO_IMAX));
                break;
            case TRESD:
                precioAsiento = precioAsiento.multiply(BigDecimal.ONE.add(RECARGO_TRESD));
                break;
            case ESTANDAR:
            default:
                // Sin recargo
                break;
        }
        
        // Aplicar descuento por tipo de cliente
        ClienteTipo tipoCliente = reserva.getCliente().getTipoCliente();
        switch (tipoCliente) {
            case ESTUDIANTE:
                precioAsiento = precioAsiento.multiply(BigDecimal.ONE.subtract(DESCUENTO_ESTUDIANTE));
                break;
            case TERCERA_EDAD:
                precioAsiento = precioAsiento.multiply(BigDecimal.ONE.subtract(DESCUENTO_TERCERA_EDAD));
                break;
            case NIÑO:
                precioAsiento = precioAsiento.multiply(BigDecimal.ONE.subtract(DESCUENTO_NIÑO));
                break;
            case GENERAL:
            default:
                // Sin descuento
                break;
        }
        
        // Calcular total por cantidad de asientos
        int cantidadAsientos = reserva.getAsientos().size();
        precioTotal = precioAsiento.multiply(new BigDecimal(cantidadAsientos));
        
        return precioTotal;
    }
}

// Administrador.java
public class Administrador {
    private List<Pelicula> peliculas;
    private List<Sala> salas;
    private List<Funcion> funciones;
    
    // Constructor
    public Administrador() {
        this.peliculas = new ArrayList<>();
        this.salas = new ArrayList<>();
        this.funciones = new ArrayList<>();
    }
    
    // Getters
    public List<Pelicula> getPeliculas() { return peliculas; }
    public List<Sala> getSalas() { return salas; }
    public List<Funcion> getFunciones() { return funciones; }
    
    // Método específico del diagrama
    public void agregarPelicula(Pelicula pelicula) {
        if (pelicula != null && !peliculas.contains(pelicula)) {
            peliculas.add(pelicula);
            System.out.println("Película agregada: " + pelicula.getTitulo());
        }
    }
    
    // Método específico del diagrama
    public void modificarPelicula(Pelicula pelicula) {
        if (pelicula != null && peliculas.contains(pelicula)) {
            // La película ya está en la lista, se modifican sus propiedades
            System.out.println("Película modificada: " + pelicula.getTitulo());
        } else {
            System.out.println("Película no encontrada para modificar");
        }
    }
    
    // Método específico del diagrama
    public void configurarFuncion(Funcion funcion) {
        if (funcion != null && !funciones.contains(funcion)) {
            // Verificar que la película y sala existan
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
    
    // Métodos auxiliares
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
    }
}


