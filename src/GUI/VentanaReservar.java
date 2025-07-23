package GUI;

import java.awt.*;
import javax.swing.*;

public class VentanaReservar extends JFrame {
    public VentanaReservar() {
        setTitle("Reservar");
        setSize(600, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel principal con layout y margen
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBackground(UIConfig.BACKGROUND_COLOR);
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Cabecera
        JLabel header = new JLabel("Ventana de Reserva", SwingConstants.CENTER);
        header.setFont(new Font("Arial", Font.BOLD, 20));
        header.setBackground(UIConfig.BACKGROUND_COLOR);
        panel.add(header, BorderLayout.NORTH);

        // Panel central (se le añade un espacio para asegurar que no se colapse)
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new BoxLayout(panelCentral, BoxLayout.Y_AXIS));
        panelCentral.setBackground(UIConfig.BACKGROUND_COLOR);
        // Agrega un espacio vertical para forzar el tamaño del panel central
        panelCentral.add(Box.createVerticalStrut(50));
        panel.add(panelCentral, BorderLayout.CENTER);

        // Panel inferior para los botones
        JPanel botonesPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        botonesPanel.setBackground(UIConfig.BACKGROUND_COLOR);
        
        JButton btnAñadirReserva = new JButton("Añadir Reserva");
        btnAñadirReserva.setFont(UIConfig.BUTTON_FONT);
        btnAñadirReserva.addActionListener((_) -> 
            JOptionPane.showMessageDialog(this, "Reserva añadida exitosamente.")
        );

        JButton btnCancelarReserva = new JButton("Cancelar Reserva");
        btnCancelarReserva.setFont(UIConfig.BUTTON_FONT);
        btnCancelarReserva.addActionListener((_) -> 
            JOptionPane.showMessageDialog(this, "Reserva cancelada.")
        );
        
        botonesPanel.add(btnAñadirReserva);
        botonesPanel.add(btnCancelarReserva);
        panel.add(botonesPanel, BorderLayout.SOUTH);
        
        setContentPane(panel);
        setVisible(true);
    }
}
