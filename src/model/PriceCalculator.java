package model;

import java.math.BigDecimal;

public class PriceCalculator {
    private static final BigDecimal PRECIO_BASE = new BigDecimal("15000");
    private static final BigDecimal DESCUENTO_ESTUDIANTE = new BigDecimal("0.20");
    private static final BigDecimal DESCUENTO_TERCERA_EDAD = new BigDecimal("0.30");
    private static final BigDecimal DESCUENTO_NIÑO = new BigDecimal("0.40");
    private static final BigDecimal RECARGO_VIP = new BigDecimal("0.50");
    private static final BigDecimal RECARGO_IMAX = new BigDecimal("0.80");
    private static final BigDecimal RECARGO_TRESD = new BigDecimal("0.30");

    public BigDecimal calcularPrecio(Reserva reserva) {
        BigDecimal precioAsiento = PRECIO_BASE;
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
                break;
        }
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
                break;
        }

        int cantidadAsientos = reserva.getAsientos().size();
        // Calcular precio total como precio por asiento multiplicado por cantidad
        return precioAsiento.multiply(BigDecimal.valueOf(cantidadAsientos));
    }
}