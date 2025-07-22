import java.util.HashMap;
import java.util.Map;
public class Sala {
    private Integer id;
    private String nombre;
    private SalaTipo tipo;
    private Integer capacidad;
    private Map<Integer, Asiento> distribucion;
    
    public Sala(Integer id, String nombre, SalaTipo tipo, Integer capacidad) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.capacidad = capacidad;
        this.distribucion = new HashMap<>();
    }

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

    public void configurarSala() {
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
