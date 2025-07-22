package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import model.*;

public class VentanaReserva extends JFrame {
    private JComboBox<Sala> comboSalas;
    private JComboBox<Funcion> comboFunciones;
    private JList<Asiento> listaAsientos;
    private DefaultListModel<Asiento> modeloAsientos;
    private JButton btnConfirmar;
    private Administrador admin;
    private Cliente cliente;

    public VentanaReserva(Administrador admin, Cliente cliente) {
        this.admin = admin;
        this.cliente = cliente;

        setTitle("Reservar Asiento");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        setLayout(new BorderLayout(10, 10));

        JPanel panelSuperior = new JPanel(new GridLayout(3, 2, 10, 10));
        panelSuperior.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panelSuperior.add(new JLabel("Sala:"));
        comboSalas = new JComboBox<>(admin.getSalas().toArray(new Sala[0]));
        panelSuperior.add(comboSalas);

        panelSuperior.add(new JLabel("Función:"));
        comboFunciones = new JComboBox<>();
        panelSuperior.add(comboFunciones);

        panelSuperior.add(new JLabel("Asientos disponibles:"));
        modeloAsientos = new DefaultListModel<>();
        listaAsientos = new JList<>(modeloAsientos);
        listaAsientos.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        JScrollPane scrollAsientos = new JScrollPane(listaAsientos);
        panelSuperior.add(scrollAsientos);

        add(panelSuperior, BorderLayout.CENTER);

        btnConfirmar = new JButton("Confirmar Reserva");
        add(btnConfirmar, BorderLayout.SOUTH);

        // Listeners
        comboSalas.addActionListener(e -> actualizarFunciones());
        comboFunciones.addActionListener(e -> actualizarAsientos());

        btnConfirmar.addActionListener(e -> confirmarReserva());

        // Inicializar combos
        if (comboSalas.getItemCount() > 0) {
            comboSalas.setSelectedIndex(0);
            actualizarFunciones();
        }
    }

    private void actualizarFunciones() {
        Sala salaSeleccionada = (Sala) comboSalas.getSelectedItem();
        comboFunciones.removeAllItems();
        if (salaSeleccionada != null) {
            for (Funcion f : admin.getFunciones()) {
                if (f.getSala().equals(salaSeleccionada)) {
                    comboFunciones.addItem(f);
                }
            }
        }
        if (comboFunciones.getItemCount() > 0) {
            comboFunciones.setSelectedIndex(0);
            actualizarAsientos();
        } else {
            modeloAsientos.clear();
        }
    }

    private void actualizarAsientos() {
        modeloAsientos.clear();
        Funcion funcion = (Funcion) comboFunciones.getSelectedItem();
        if (funcion != null) {
            for (Asiento asiento : funcion.getSala().getDistribucion().values()) {
                if (asiento.getEstado() == AsientoEstado.DISPONIBLE) {
                    modeloAsientos.addElement(asiento);
                }
            }
        }
    }

    private void confirmarReserva() {
        Funcion funcion = (Funcion) comboFunciones.getSelectedItem();
        List<Asiento> asientosSeleccionados = listaAsientos.getSelectedValuesList();
        if (funcion == null || asientosSeleccionados.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Seleccione función y asientos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Reserva reserva = new Reserva((int) (Math.random() * 10000), cliente, funcion);
        reserva.setAsientos(asientosSeleccionados);
        reserva.calcularTotal();
        BoletoDigital boleto = reserva.confirmar();

        JOptionPane.showMessageDialog(this, boleto.generarPDF(), "Reserva Confirmada", JOptionPane.INFORMATION_MESSAGE);
        actualizarAsientos();
    }
}
