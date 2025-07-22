package GUI;
import javax.swing.*;
import java.awt.*;
//Ya hice que el botón nos lleve a una ventana de reserva, pero no sé si toca crear una nueva clase para esa ventana o que se hace ajsdjafsd
//no entiendo, como asi? lajsldka
public class VentanaPrincipal extends JFrame {
    public VentanaPrincipal() {
        setTitle("CineUNAL");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel principal con BorderLayout
        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Título
        JLabel titulo = new JLabel("Bienvenido a CineUNAL", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        panelPrincipal.add(titulo, BorderLayout.NORTH);

        // Panel central con opciones
        JPanel panelCentro = new JPanel();
        panelCentro.setLayout(new BoxLayout(panelCentro, BoxLayout.Y_AXIS));
        panelCentro.setOpaque(false);

        JButton btnReservar = new JButton("Reservar");
        btnReservar.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnReservar.setFont(new Font("Arial", Font.PLAIN, 18));
        panelCentro.add(btnReservar);
        panelCentro.add(Box.createRigidArea(new Dimension(0, 15)));
        btnReservar.addActionListener(e -> {
            VentanaReserva ventanaReserva = new VentanaReserva();
            ventanaReserva.setVisible(true);
        });

        JButton btnFunciones = new JButton("Ver Funciones");
        btnFunciones.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnFunciones.setFont(new Font("Arial", Font.PLAIN, 18));
        panelCentro.add(btnFunciones);
        panelCentro.add(Box.createRigidArea(new Dimension(0, 15)));

        JButton btnSalir = new JButton("Salir");
        btnSalir.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnSalir.setFont(new Font("Arial", Font.PLAIN, 18));
        btnSalir.addActionListener(e -> System.exit(0));
        panelCentro.add(btnSalir);

        panelPrincipal.add(panelCentro, BorderLayout.CENTER);

        // Pie de página
        JLabel pie = new JLabel("© 2025 CineUNAL", SwingConstants.CENTER);
        pie.setFont(new Font("Arial", Font.ITALIC, 12));
        panelPrincipal.add(pie, BorderLayout.SOUTH);

        setContentPane(panelPrincipal);
        setVisible(true);
    }

    public static void main(String[] args) {
        // Usa el look and feel del sistema operativo
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {}
        new VentanaPrincipal();
    }
}