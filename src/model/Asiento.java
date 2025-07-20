package model;

/**
 * Representa un asiento en la sala de cine.
 */
public class Asiento {
    private int fila;
    private int numero;
    private boolean reservado;

    /**
     * Construye un Asiento con fila y número específicos.
     * Por defecto, el asiento no está reservado.
     *
     * @param fila    Número de fila (1..n)
     * @param numero  Número de asiento dentro de la fila (1..m)
     */
    public Asiento(int fila, int numero) {
        this.fila = fila;
        this.numero = numero;
        this.reservado = false;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean isReservado() {
        return reservado;
    }

    /**
     * Marca el asiento como reservado o libresegún el valor dado.
     *
     * @param reservado true para reservar, false para liberar
     */
    public void setReservado(boolean reservado) {
        this.reservado = reservado;
    }

    /**
     * Reserva el asiento (pasa reservado = true).
     */
    public void reservar() {
        this.reservado = true;
    }

    /**
     * Libera el asiento (pasa reservado = false).
     */
    public void liberar() {
        this.reservado = false;
    }

    @Override
    public String toString() {
        return "Asiento[fila=" + fila + ", numero=" + numero + ", reservado=" + reservado + "]";
    }
}
