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




