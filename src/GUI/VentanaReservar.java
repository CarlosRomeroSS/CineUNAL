package GUI;

import java.awt.*;
import javax.swing.*;

public class VentanaReservar extends JFrame {
    public VentanaReservar() {
        setTitle("Reservar");
        setSize(400, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel principal con layout y margen
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Cabecera
        JLabel header = new JLabel("Ventana de Reserva", SwingConstants.CENTER);
        header.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(header, BorderLayout.NORTH);

        // Panel central donde se agregarán los métodos
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new BoxLayout(panelCentral, BoxLayout.Y_AXIS));

        // Ejemplo de un botón que ejecuta un método
        JButton btnMetodo = new JButton("Ejecutar Método 1");
        btnMetodo.addActionListener(e -> ejecutarMetodo1());
        panelCentral.add(btnMetodo);

        // Aquí puedes agregar más componentes y métodos

        panel.add(panelCentral, BorderLayout.CENTER);

        setContentPane(panel);
        setVisible(true);
    }

    private void ejecutarMetodo1() {
        // Implementa tu método aquí
        JOptionPane.showMessageDialog(this, "Método 1 ejecutado.");
    }
}
