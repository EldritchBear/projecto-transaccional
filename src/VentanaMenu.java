import javax.swing.*;

// se podría agregar otro botón

public class VentanaMenu {
    private JLabel Menú;
    private JButton listaDePersonasButton;
    private JButton agregarPersonaButton;
    public JPanel panel;

    public VentanaMenu(Regiones regiones, JFrame ventana) {
        ventana.setContentPane(this.panel);

        agregarPersonaButton.addActionListener(e -> {
            ventana.setContentPane(new VentanaAgregar(regiones, ventana).panel);
            ventana.setSize(512, 511);
        });
        listaDePersonasButton.addActionListener(e -> {
            ventana.setContentPane(new VentanaLista(regiones, ventana).panel);
            ventana.setSize(512, 511);
        });
    }
}