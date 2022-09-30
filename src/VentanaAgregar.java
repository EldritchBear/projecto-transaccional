import javax.swing.*;

// falta implementar checkboxes para crear Personas tipo Extranjero y Funcionario
// se podría usar una sobrecarga para crearPersona(), una que reciba un bool y otra que reciba un String con la función
// revisar si una checkbox está seleccionada al momento de presionar el botón de agregar

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
    private JCheckBox funcionarioCheckBox;
    private JCheckBox extranjeroCheckBox;
    private JTextField funcionT;

    public VentanaAgregar(Regiones regiones, JFrame ventana) {
        funcionT.setEnabled(false);
        cancelarButton.addActionListener(e -> {
            ventana.setContentPane(new VentanaMenu(regiones, ventana).panel);
            ventana.setSize(512, 512);
        });
        agregarButton.addActionListener(e -> {
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
        });
        funcionarioCheckBox.addActionListener(e -> {
            if (funcionarioCheckBox.isSelected()) {
                extranjeroCheckBox.setEnabled(false);
                funcionT.setEnabled(true);
            } else {
                extranjeroCheckBox.setEnabled(true);
                funcionT.setEnabled(false);
            }
        });
        extranjeroCheckBox.addActionListener(e -> funcionarioCheckBox.setEnabled(!extranjeroCheckBox.isSelected()));
    }
}
