package GUI;

import model.Pelicula;
import model.Administrador;

import javax.swing.*;
import java.awt.*;
import java.util.List;

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

        // Placeholder: cargar películas desde el administrador
        List<Pelicula> peliculas = admin.getPeliculas();
        JComboBox<Pelicula> comboPeliculas = new JComboBox<>(peliculas.toArray(new Pelicula[0]));
        panel.add(comboPeliculas);

        JButton btnSeleccionar = new JButton("Seleccionar");
        btnSeleccionar.addActionListener(e -> {
            Pelicula seleccionada = (Pelicula) comboPeliculas.getSelectedItem();
            JOptionPane.showMessageDialog(this, "Seleccionaste: " + (seleccionada != null ? seleccionada.getTitulo() : "Ninguna"));
            // Aquí puedes continuar el flujo, por ejemplo abrir la ventana de selección de sala
        });
        panel.add(btnSeleccionar);

        add(panel);
        setVisible(true);
    }
}