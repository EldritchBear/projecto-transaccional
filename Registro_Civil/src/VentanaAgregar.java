import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaAgregar {
    private JTextField regionT;
    private JTextField nombreT;
    private JTextField rutT;
    private JTextField edadT;
    private JLabel nombre;
    private JLabel region;
    private JLabel rut;
    private JLabel edad;
    public JPanel panel;
    private JButton agregarButton;
    private JButton cancelarButton;

    private Regiones regiones;
    private JFrame ventana;
    public VentanaAgregar(Regiones regiones, JFrame ventana) {
        this.regiones = regiones;
        this.ventana = ventana;
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana.setContentPane(new VentanaMenu(regiones, ventana).panel);
                ventana.setSize(512, 512);
            }
        });
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int reg = Integer.parseInt(regionT.getText());
                String nom = nombreT.getText();
                String r = rutT.getText();
                int ed = Integer.parseInt(edadT.getText());

                try {
                    regiones.getRegion(reg).agregarPersona(nom, r, ed);
                } catch(Exception ex) {
                    JOptionPane.showMessageDialog(ventana, ex.getMessage());
                    return;
                }


                ventana.setContentPane(new VentanaMenu(regiones, ventana).panel);
                ventana.setSize(512, 512);
            }
        });
    }
}
