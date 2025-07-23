package GUI;

import model.Reserva;
import model.BoletoDigital;

import javax.swing.*;
import java.awt.*;

public class VentanaMostrarReserva extends JFrame {
    public VentanaMostrarReserva(Reserva reserva) {
        setTitle("Reserva Confirmada");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel header = new JLabel("¡Reserva Exitosa!", SwingConstants.CENTER);
        header.setFont(new Font("Arial", Font.BOLD, 22));
        panel.add(header, BorderLayout.NORTH);

        // Generar boleto digital
        BoletoDigital boleto = reserva.confirmar();
        JTextArea area = new JTextArea(boleto.generarPDF());
        area.setEditable(false);
        area.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane scroll = new JScrollPane(area);
        panel.add(scroll, BorderLayout.CENTER);

        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.addActionListener(e -> dispose());
        JPanel btnPanel = new JPanel();
        btnPanel.add(btnCerrar);
        panel.add(btnPanel, BorderLayout.SOUTH);

        setContentPane(panel);
        setVisible(true);
    }
}