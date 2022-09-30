import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VentanaLista {
    public JPanel panel;
    private JScrollPane scrollPane;
    private JTable table;
    private JButton volverButton;
    private JButton eliminarButton;
    private JTextField filtroT;
    private JButton filtrarButton;
    private JComboBox regionSeleccionada;
    private Regiones regiones;
    private JFrame frame;

    private Region region = null;

    public VentanaLista(Regiones regiones, JFrame frame) {
        this.regiones = regiones;
        this.frame = frame;

        ArrayList<Persona> arreglo;
        String[] column = {"Región", "Nombre", "Rut", "Edad"};
        DefaultTableModel tableModel = new DefaultTableModel(column, 0);

        table.setModel(tableModel);
        table.setDefaultEditor(Object.class, null);

        for (int i = 1; i < 16; i++) {
            try {arreglo = regiones.getRegion(i).getArray();} catch(Exception e) {continue;}
            if (arreglo.size() == 0) continue;
            for (Persona persona : arreglo) {
                tableModel.addRow(persona.getObjs());
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
                DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
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

        filtrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String filtro = filtroT.getText();
                ArrayList<Persona> personas;
                if (region == null) {
                    personas = regiones.getPersonas();
                } else {
                    personas = region.getArray();
                }
                DefaultTableModel nuevoModel = new DefaultTableModel(column, 0);
                for (Persona persona : personas) {
                    if (filtro.length() == 0 || persona.getRegion().getNombre().contains(filtro) || persona.getNombre().contains(filtro) ||
                            persona.getRut().contains(filtro) || String.valueOf(persona.getEdad()).contains(filtro)) {
                        Object[] objs = {persona.getRegion().getNombre(), persona.getNombre(), persona.getRut(), persona.getEdad()};
                        nuevoModel.addRow(objs);
                    }
                }
                table.setModel(nuevoModel);
            }
        });
        regionSeleccionada.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String stringSeleccion = (String)regionSeleccionada.getSelectedItem();
                stringSeleccion = String.valueOf(stringSeleccion.charAt(0));
                try {
                    region = regiones.getRegion(Integer.parseInt(stringSeleccion));
                } catch (Exception exc) {
                    System.out.println("Región no encontrada");
                    region = null;
                }
            }
        });
    }

}
