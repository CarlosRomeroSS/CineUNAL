import java.util.ArrayList;
import java.util.List;

public class Sala {
    private int id;
    private String nombre;
    private String tipoSala;
    private String pelicula;
    private String horario;
    private int filas;
    private int asientosPorFila;
    private List<Asiento> asientos;

    public Sala(int id, String nombre, String tipoSala, String pelicula, String horario) {
        this.id = id;
        this.nombre = nombre;
        this.tipoSala = tipoSala.toUpperCase();
        this.pelicula = pelicula;
        this.horario = horario;
        this.asientos = new ArrayList<>();
        configurarSegunTipo();
        inicializarAsientos();
    }
    private void configurarSegunTipo() {
        switch (tipoSala) {
            case "VIP":
                filas = 8;
                asientosPorFila = 12;
                break;
            case "IMAX":
                filas = 15;
                asientosPorFila = 30;
                break;
            case "3D":
                filas = 12;
                asientosPorFila = 25;
                break;
            case "2D":
            default:
                filas = 10;
                asientosPorFila = 20;
                break;
        }
    }
    private void inicializarAsientos() {
        for (int i = 0; i < filas; i++) {
            char filaLetra = (char) ('A' + i);
            for (int j = 1; j <= asientosPorFila; j++) {
                asientos.add(new Asiento(filaLetra, j));
            }
        }
    }

    public Asiento obtenerAsiento(char fila, int numero) {
        for (Asiento a : asientos) {
            if (a.getFila() == fila && a.getNumero() == numero) {
                return a;
            }
        }
        return null;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipoSala() {
        return tipoSala;
    }

    public String getPelicula() {
        return pelicula;
    }

    public String getHorario() {
        return horario;
    }

    public List<Asiento> getAsientos() {
        return asientos;
    }

    public int getFilas() {
        return filas;
    }

    public int getAsientosPorFila() {
        return asientosPorFila;
    }

    @Override
    public String toString() {
        return "Sala{id=" + id + ", nombre='" + nombre + "', tipoSala='" + tipoSala +
                "', pelicula='" + pelicula + "', horario='" + horario +
                "', filas=" + filas + ", asientosPorFila=" + asientosPorFila + "}";
    }
}


