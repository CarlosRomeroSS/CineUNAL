package model;

/**
 * Representa un asiento en la sala de cine.
 */
public class Asiento {
    private final char fila;
    private final int numero;
    private boolean reservado;

    private static final char FILA_MIN = 'A';
    private static final char FILA_MAX = 'P';
    private static final int NUMERO_MIN = 1;
    private static final int NUMERO_MAX = 35;

    /**
     * Construye un Asiento con fila y número específicos.
     * Por defecto, el asiento no está reservado.
     *
     * @param fila    Letra de fila (A..P, sin 'Ñ')
     * @param numero  Número de asiento dentro de la fila (1..35)
     * @throws IllegalArgumentException si los valores están fuera de rango
     */
    public Asiento(char fila, int numero) {
        if (fila < FILA_MIN || fila > FILA_MAX) {
            throw new IllegalArgumentException(
                "Fila inválida: " + fila + ". Debe ser entre " + FILA_MIN + " y " + FILA_MAX
            );
        }
        if (numero < NUMERO_MIN || numero > NUMERO_MAX) {
            throw new IllegalArgumentException(
                "Número inválido: " + numero + ". Debe estar entre " + NUMERO_MIN + " y " + NUMERO_MAX
            );
        }
        this.fila = fila;
        this.numero = numero;
        this.reservado = false;
    }

    public char getFila() {
        return fila;
    }

    public int getNumero() {
        return numero;
    }

    public boolean isReservado() {
        return reservado;
    }

    /**
     * Marca el asiento como reservado.
     */
    public void reservar() {
        this.reservado = true;
    }

    /**
     * Libera el asiento.
     */
    public void liberar() {
        this.reservado = false;
    }

    @Override
    public String toString() {
        return "Asiento[fila=" + fila + ", numero=" + numero + ", reservado=" + reservado + "]";
    }
}
