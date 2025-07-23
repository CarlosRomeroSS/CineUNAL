package GUI;

import model.Administrador;
import model.Sala;
import model.Asiento;
import model.Pelicula;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;

public class VentanaSeleccionAsientos extends JFrame {
    public VentanaSeleccionAsientos(Administrador admin, Sala sala, Pelicula pelicula) {
        setTitle("Selecciona Asientos");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel label = new JLabel("Selecciona los asientos:");
        panel.add(label);

        // Obtener los asientos disponibles de la sala
        List<Asiento> asientosDisponibles = new ArrayList<>();
        for (Asiento asiento : sala.getDistribucion().values()) {
            if (asiento.getEstado() == model.AsientoEstado.DISPONIBLE) {
                asientosDisponibles.add(asiento);
            }
        }

        JList<Asiento> listaAsientos = new JList<>(asientosDisponibles.toArray(new Asiento[0]));
        listaAsientos.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        JScrollPane scrollPane = new JScrollPane(listaAsientos);
        scrollPane.setPreferredSize(new Dimension(300, 120));
        panel.add(scrollPane);

        JButton btnConfirmar = new JButton("Confirmar selección");
        btnConfirmar.addActionListener(e -> {
            List<Asiento> seleccionados = listaAsientos.getSelectedValuesList();
            JOptionPane.showMessageDialog(this, "Seleccionaste: " + seleccionados);
            // Aquí puedes continuar el flujo, por ejemplo crear la reserva
        });
        panel.add(btnConfirmar);

        add(panel);
        setVisible(true);
    }
}
