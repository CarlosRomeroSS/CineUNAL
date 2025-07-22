package GUI;
import java.awt.*;
import javax.swing.*;

public class VentanaPrincipal extends JFrame {
    public VentanaPrincipal() {
        setTitle("CineUNAL");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel principal con BorderLayout y márgenes
        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Cabecera: título (y opción para agregar un logo)
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setOpaque(false);
        JLabel titulo = new JLabel("Bienvenido a CineUNAL", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 26)); // Fuente más grande para el título
        headerPanel.add(titulo, BorderLayout.CENTER);
        // Opcional: agregar un logo
        // ImageIcon logo = new ImageIcon("ruta/a/logo.png");
        // JLabel logoLabel = new JLabel(logo);
        // headerPanel.add(logoLabel, BorderLayout.WEST);
        panelPrincipal.add(headerPanel, BorderLayout.NORTH);

        // Panel central con opciones, utilizando BoxLayout
        JPanel panelCentro = new JPanel();
        panelCentro.setLayout(new BoxLayout(panelCentro, BoxLayout.Y_AXIS));
        panelCentro.setOpaque(false);

        // Se crean y añaden botones estilizados
        JButton btnReservar = createStyledButton("Reservar");
        btnReservar.addActionListener(e -> new VentanaReservar());
        JButton btnFunciones = createStyledButton("Ver Funciones");
        JButton btnSalir = createStyledButton("Salir");
        btnSalir.addActionListener(e -> System.exit(0));

        panelCentro.add(btnReservar);
        panelCentro.add(Box.createRigidArea(new Dimension(0, 15)));
        panelCentro.add(btnFunciones);
        panelCentro.add(Box.createRigidArea(new Dimension(0, 15)));
        panelCentro.add(btnSalir);

        panelPrincipal.add(panelCentro, BorderLayout.CENTER);

        // Pie de página
        JLabel pie = new JLabel("© 2025 CineUNAL", SwingConstants.CENTER);
        pie.setFont(new Font("Arial", Font.ITALIC, 12));
        panelPrincipal.add(pie, BorderLayout.SOUTH);

        setContentPane(panelPrincipal);
        setVisible(true);
    }

    // Método para crear un botón con estilo consistente
    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setFont(new Font("Arial", Font.PLAIN, 18));
        button.setFocusPainted(false);
        return button;
    }

    public static void main(String[] args) {
        // Usa el look and feel del sistema operativo
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {}
        SwingUtilities.invokeLater(() -> new VentanaPrincipal());
    }
}