import java.util.ArrayList;

public class Reserva {
    private integer id;
    private Cliente cliente;
    private Funcion funcion;
    private List<Asiento> asientos;
    private String fecha;
    private double total;

    public Reserva (integer id, Cliente cliente, Funcion funcion, String fecha){
        this.id = id;
        this.cliente = cliente;
        this.funcion = funcion;
        this.asientos = new ArrayList<>();
        this.fecha = fecha;
        this.total = 0;
    }
}