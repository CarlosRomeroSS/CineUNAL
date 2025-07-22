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




