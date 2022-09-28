import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaMenu {
    private JLabel Menú;
    private JButton listaDePersonasButton;
    private JButton agregarPersonaButton;
    private JButton buscarPersonaButton;
    public JPanel panel;
    private Regiones regiones;
    private JFrame ventana;

    public VentanaMenu(Regiones regiones, JFrame ventana) {
        this.regiones = regiones;
        this.ventana = ventana;
        ventana.setContentPane(this.panel);

        agregarPersonaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana.setContentPane(new VentanaAgregar(regiones, ventana).panel);
                ventana.setSize(512, 511);
            }
        });
        listaDePersonasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana.setContentPane(new VentanaLista(regiones, ventana).panel);
                ventana.setSize(512, 511);
            }
        });
    }
}