package GUI;

import model.Administrador;
import model.Pelicula;
import model.Funcion;
import model.Sala;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class VenatanaSeleccionSala extends JFrame {
    public VenatanaSeleccionSala(Administrador admin, Pelicula pelicula) {
        setTitle("Selecciona una Sala");
        setSize(350, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel label = new JLabel("Sala:");
        panel.add(label);

        // Buscar funciones de la película y extraer las salas disponibles
        List<Funcion> funciones = admin.buscarFuncionesPorPelicula(pelicula);
        DefaultComboBoxModel<Sala> modeloSalas = new DefaultComboBoxModel<>();
        for (Funcion funcion : funciones) {
            modeloSalas.addElement(funcion.getSala());
        }
        JComboBox<Sala> comboSalas = new JComboBox<>(modeloSalas);
        panel.add(comboSalas);

        JButton btnSeleccionar = new JButton("Seleccionar");
        btnSeleccionar.addActionListener(e -> {
            Sala salaSeleccionada = (Sala) comboSalas.getSelectedItem();
            JOptionPane.showMessageDialog(this, "Seleccionaste: " + (salaSeleccionada != null ? salaSeleccionada.getNombre() : "Ninguna"));
            // Aquí puedes abrir la ventana para seleccionar asientos
            // new VentanaSeleccionAsientos(admin, salaSeleccionada, pelicula);
        });
        panel.add(btnSeleccionar);

        add(panel);
        setVisible(true);
    }
}
