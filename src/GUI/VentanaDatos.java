package GUI;

import java.util.List;
import javax.swing.*;
import model.Asiento;
import model.Cliente;
import model.ClienteTipo;
import model.Funcion;
import model.Reserva;

public class VentanaDatos extends JFrame {
    public VentanaDatos(Funcion funcion, List<Asiento> asientosSeleccionados) {
        setTitle("Datos del Cliente");
        setSize(350, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel lblNombre = new JLabel("Nombre:");
        JTextField txtNombre = new JTextField();
        panel.add(lblNombre);
        panel.add(txtNombre);

        JLabel lblEmail = new JLabel("Email:");
        JTextField txtEmail = new JTextField();
        panel.add(lblEmail);
        panel.add(txtEmail);

        JLabel lblTipo = new JLabel("Tipo de Cliente:");
        JComboBox<ClienteTipo> comboTipo = new JComboBox<>(ClienteTipo.values());
        panel.add(lblTipo);
        panel.add(comboTipo);

        JButton btnConfirmar = new JButton("Confirmar");
        btnConfirmar.addActionListener(e -> {
            String nombre = txtNombre.getText();
            String email = txtEmail.getText();
            ClienteTipo tipo = (ClienteTipo) comboTipo.getSelectedItem();
            Cliente cliente = new Cliente(null, nombre, email, tipo);

            Reserva reserva = new Reserva(1, cliente, funcion);
            reserva.setAsientos(asientosSeleccionados);
            reserva.calcularTotal();
            reserva.confirmar();

            new VentanaMostrarReserva(reserva);
            dispose();
        });
        panel.add(btnConfirmar);

        add(panel);
        setVisible(true);
    }
}
