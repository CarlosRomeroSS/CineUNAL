package GUI;

import java.awt.*;

public class UIConfig {
    public static final Color BACKGROUND_COLOR = new Color(230, 230, 250); // color lavanda claro
    public static final Font HEADER_FONT = new Font("Arial", Font.BOLD, 26);
    public static final Font BUTTON_FONT = new Font("Arial", Font.PLAIN, 18);
    public static final Font TEXT_FONT = new Font("Arial", Font.PLAIN, 14);

public static void main(String[] args) {
    javax.swing.SwingUtilities.invokeLater(() -> new VentanaPrincipal());
}
}