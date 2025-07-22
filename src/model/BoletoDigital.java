import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.math.BigDecimal;
public class BoletoDigital {
    private String idQR;
    private Reserva reserva;
    private String formatoPDF;

    public BoletoDigital() {
        this.idQR = generarQR();
        this.formatoPDF = "PDF";
    }
    public String getIdQR() { return idQR; }
    public void setIdQR(String idQR) { this.idQR = idQR; }
    
    public Reserva getReserva() { return reserva; }
    public void setReserva(Reserva reserva) { this.reserva = reserva; }
    
    public String getFormatoPDF() { return formatoPDF; }
    public void setFormatoPDF(String formatoPDF) { this.formatoPDF = formatoPDF; }
    
    public String generarPDF() {
        StringBuilder pdf = new StringBuilder();
        pdf.append("=== BOLETO DIGITAL CINE UNAL ===\n");
        pdf.append("QR: ").append(idQR).append("\n");
        pdf.append("Cliente: ").append(reserva.getCliente().getNombre()).append("\n");
        pdf.append("Película: ").append(reserva.getFuncion().getPelicula().getTitulo()).append("\n");
        pdf.append("Sala: ").append(reserva.getFuncion().getSala().getNombre()).append("\n");

        // Formatear la fecha y hora como AA/MM/DD y HH/MM/SS
        java.time.LocalDateTime fechaHora = reserva.getFuncion().getFechaHora();
        String fecha = String.format("%02d/%02d/%02d", 
            fechaHora.getYear() % 100, fechaHora.getMonthValue(), fechaHora.getDayOfMonth());
        String hora = String.format("%02d:%02d:%02d", 
            fechaHora.getHour(), fechaHora.getMinute(), fechaHora.getSecond());

        pdf.append("Fecha (YYY/mm/dd): ").append(fecha).append("\n");
        pdf.append("Hora (hh:nn:ss): ").append(hora).append("\n");
        pdf.append("Asientos: ");
        
        for (Asiento asiento : reserva.getAsientos()) {
            pdf.append(asiento.getFila()).append(asiento.getNumero()).append(" ");
        }
        
        pdf.append("\nTotal: $").append(reserva.getTotal()).append("\n");
        pdf.append("===============================");
        
        return pdf.toString();
    }

    private String generarQR() {
        return "QR" + System.currentTimeMillis();
    }
}
