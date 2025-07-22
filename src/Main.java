import java.time.DateTime;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.math.BigDecimal;
public class Main {
    public static void main(String[] args) {
        Administrador admin = new Administrador();
        
        Pelicula pelicula = new Pelicula(1, "Avatar", "Ciencia Ficción", 180, 
            "PG-13", "Una historia épica...", "James Cameron");
        admin.agregarPelicula(pelicula);
        
        System.out.println("¡Sistema funcionando!");
    }
}





