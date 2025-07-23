package GUI;

import java.util.List;
import javax.swing.*;
import model.Administrador;
import model.Funcion;
import model.Pelicula;
import model.Sala;

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
        });
        panel.add(btnSeleccionar);

        add(panel);
        setVisible(true);
    }
}
