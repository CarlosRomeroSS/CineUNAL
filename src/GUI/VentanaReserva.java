package GUI;

import javax.swing.*;
import java.awt.*;

public class VentanaReserva extends JFrame {
    public VentanaReserva() {
        setTitle("Reservar Asiento");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JLabel label = new JLabel("Aquí puedes seleccionar sala, asiento, etc.", SwingConstants.CENTER);
        add(label, BorderLayout.CENTER);
    }
}
