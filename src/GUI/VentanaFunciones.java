package GUI;

import java.awt.*;
import javax.swing.*;

public class VentanaFunciones extends JFrame {
    public VentanaFunciones() {
        setTitle("Funciones de Películas");
        setSize(600, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel principal para la ventana
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(UIConfig.BACKGROUND_COLOR);
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Encabezado con el mismo estilo que en VentanaReservar
        JLabel header = new JLabel("Funciones de Películas", SwingConstants.CENTER);
        header.setFont(new Font("Arial", Font.BOLD, 20));
        header.setBackground(UIConfig.BACKGROUND_COLOR);
        panel.add(header, BorderLayout.NORTH);

        // Información de las funciones con formato unificado
        String funcionesInfo = ""
            + "Función 1:\n"
            + "Película: Avatar\n"
            + "Sala: Sala 1\n"
            + "Fecha/Hora: 21/07/25 19:30:00\n"
            + "Sillas Disponibles: 25\n\n"
            + "Función 2:\n"
            + "Película: Avatar\n"
            + "Sala: Sala 2\n"
            + "Fecha/Hora: 21/07/25 21:30:00\n"
            + "Sillas Disponibles: 30\n\n"
            + "Función 3:\n"
            + "Película: Otra Película\n"
            + "Sala: Sala VIP\n"
            + "Fecha/Hora: 21/07/25 20:00:00\n"
            + "Sillas Disponibles: 10\n";
        
        JTextArea textArea = new JTextArea(funcionesInfo);
        textArea.setEditable(false);
        textArea.setFont(UIConfig.TEXT_FONT);
        textArea.setBackground(UIConfig.BACKGROUND_COLOR);

        JScrollPane scrollPane = new JScrollPane(textArea);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        // Panel inferior para los botones
        JPanel botonesPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        botonesPanel.setBackground(UIConfig.BACKGROUND_COLOR);
        
        JButton btnAñadirFuncion = new JButton("Añadir Función");
        btnAñadirFuncion.setFont(UIConfig.BUTTON_FONT);
        
        JButton btnCancelarFuncion = new JButton("Cancelar Función");
        btnCancelarFuncion.setFont(UIConfig.BUTTON_FONT);
        
        botonesPanel.add(btnAñadirFuncion);
        botonesPanel.add(btnCancelarFuncion);
        panel.add(botonesPanel, BorderLayout.SOUTH);

        setContentPane(panel);
        setVisible(true);
    }
}
