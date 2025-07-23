package GUI;
import java.awt.*;
import javax.swing.*;

public class VentanaHacerReserva extends JFrame{
    public VentanaHacerReserva() {
        setTitle("Hacer Reserva");
        setSize(600, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Aquí se puede agregar el contenido específico de la ventana de hacer reserva
        // Por ejemplo, un formulario para ingresar los detalles de la reserva

        // Configuración del panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(UIConfig.BACKGROUND_COLOR);
        
        // Encabezado
        JLabel header = new JLabel("Hacer Reserva", SwingConstants.CENTER);
        header.setFont(new Font("Arial", Font.BOLD, 20));
        header.setBackground(UIConfig.BACKGROUND_COLOR);
        panel.add(header, BorderLayout.NORTH);

        // Aquí se pueden agregar más componentes como formularios, botones, etc.

        add(panel);
        
    }

    // Métodos adicionales para manejar la lógica de hacer reservas
}
