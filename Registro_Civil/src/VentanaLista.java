import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaLista {
    public JPanel panel;
    private JScrollPane scrollPane;
    private JTable table;
    private JButton volverButton;
    private JButton eliminarButton;
    private JTextField filtroT;
    private JButton filtrarButton;
    private Regiones regiones;
    private JFrame frame;

    public VentanaLista(Regiones regiones, JFrame frame) {
        this.regiones = regiones;
        this.frame = frame;

        Object[] arreglo;
        String[] column = {"Región", "Nombre", "Rut", "Edad"};
        DefaultTableModel tableModel = new DefaultTableModel(column, 0);

        table.setModel(tableModel);
        table.setDefaultEditor(Object.class, null);

        for (int i = 1; i < 16; i++) {
            try {arreglo = regiones.getRegion(i).getArray();} catch(Exception e) {continue;}
            if (arreglo.length == 0) continue;
            for (Object o : arreglo) {
                Persona persona = (Persona) o;
                Object[] objs = {persona.getRegion().getNombre(), persona.getNombre(), persona.getRut(), persona.getEdad()};
                tableModel.addRow(objs);
            }
        }

        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(new VentanaMenu(regiones, frame).panel);
                frame.setSize(512, 512);
            }
        });
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] seleccionadas = table.getSelectedRows();
                if (seleccionadas.length == 0) return;
                for (int i : seleccionadas) {
                    String rut = (String) tableModel.getValueAt(i, 2);
                    Persona persona = regiones.buscarPersona(rut);

                    persona.getRegion().eliminarPersona(persona);
                }

                int eliminadas = 0;
                for (int pos : seleccionadas) {
                    tableModel.removeRow(pos - eliminadas);
                    eliminadas++;
                }


            }
        });

    }

}