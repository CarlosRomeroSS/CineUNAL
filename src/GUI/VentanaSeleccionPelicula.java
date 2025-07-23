package GUI;

import java.util.List;
import javax.swing.*;
import model.Administrador;
import model.Pelicula;

public class VentanaSeleccionPelicula extends JFrame {
    public VentanaSeleccionPelicula(Administrador admin) {
        setTitle("Selecciona una Película");
        setSize(350, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel label = new JLabel("Película:");
        panel.add(label);

        List<Pelicula> peliculas = admin.getPeliculas();
        JComboBox<Pelicula> comboPeliculas = new JComboBox<>(peliculas.toArray(new Pelicula[0]));
        panel.add(comboPeliculas);

        JButton btnSeleccionar = new JButton("Seleccionar");
        btnSeleccionar.addActionListener(e -> {
            Pelicula seleccionada = (Pelicula) comboPeliculas.getSelectedItem();
            JOptionPane.showMessageDialog(this, "Seleccionaste: " + (seleccionada != null ? seleccionada.getTitulo() : "Ninguna"));
        });
        panel.add(btnSeleccionar);

        add(panel);
        setVisible(true);
    }
}