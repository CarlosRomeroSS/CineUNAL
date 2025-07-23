package GUI;

import java.awt.*;
import javax.swing.*;

public class VentanaPrincipal extends JFrame {
    public VentanaPrincipal() {
        setTitle("CineUNAL");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panelPrincipal.setBackground(UIConfig.BACKGROUND_COLOR);

        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setOpaque(false);
        headerPanel.setBackground(UIConfig.BACKGROUND_COLOR);
        JLabel titulo = new JLabel("Bienvenido a CineUNAL", SwingConstants.CENTER);
        titulo.setFont(UIConfig.HEADER_FONT);
        headerPanel.add(titulo, BorderLayout.CENTER);
        panelPrincipal.add(headerPanel, BorderLayout.NORTH);

        JPanel panelCentro = new JPanel();
        panelCentro.setLayout(new BoxLayout(panelCentro, BoxLayout.Y_AXIS));
        panelCentro.setBackground(UIConfig.BACKGROUND_COLOR);

        JButton btnReservar = createStyledButton("Reservar");
        btnReservar.addActionListener(e -> new VentanaReservar());

        JButton btnFunciones = createStyledButton("Ver Funciones");
        btnFunciones.addActionListener(e -> new VentanaFunciones());

        JButton btnSalir = createStyledButton("Salir");
        btnSalir.addActionListener(e -> System.exit(0));

        panelCentro.add(btnReservar);
        panelCentro.add(Box.createRigidArea(new Dimension(0, 15)));
        panelCentro.add(btnFunciones);
        panelCentro.add(Box.createRigidArea(new Dimension(0, 15)));
        panelCentro.add(btnSalir);
        panelPrincipal.add(panelCentro, BorderLayout.CENTER);

        JLabel pie = new JLabel("© 2025 CineUNAL", SwingConstants.CENTER);
        pie.setFont(new Font("Arial", Font.ITALIC, 12));
        pie.setBackground(UIConfig.BACKGROUND_COLOR);
        panelPrincipal.add(pie, BorderLayout.SOUTH);

        setContentPane(panelPrincipal);
        setVisible(true);
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setFont(UIConfig.BUTTON_FONT);
        button.setFocusPainted(false);
        return button;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VentanaPrincipal());
    }
}