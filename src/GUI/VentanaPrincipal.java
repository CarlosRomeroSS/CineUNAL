import javax.swing.*;

public class VentanaPrincipal extends JFrame {
    public VentanaPrincipal() {
        setTitle("CineUNAL");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JButton boton = new JButton("Reservar");
        add(boton);

        setVisible(true);
    }

    public static void main(String[] args) {
        new VentanaPrincipal();
    }
}
