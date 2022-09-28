import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

public class Regiones {
    private ArrayList<Region> regiones;

    public Regiones (){
        regiones = new ArrayList<Region>(16);
        regiones.add(new Region("Tarapacá", 1));
        regiones.add(new Region("Antofagasta", 2));
        regiones.add(new Region("Atacama", 3));
        regiones.add(new Region("Coquimbo", 4));
        regiones.add(new Region("Valparaíso", 5));
        regiones.add(new Region("Libertador General Bernardo O’Higgins", 6));
        regiones.add(new Region("Maule", 7));
        regiones.add(new Region("Biobío", 8));
        regiones.add(new Region("La Araucanía", 9));
        regiones.add(new Region("Los Lagos", 10));
        regiones.add(new Region("Aysén del General Carlos Ibáñez del Campo", 11));
        regiones.add(new Region("Magallanes y Antártica Chilena", 12));
        regiones.add(new Region("Metropolitana de Santiago", 13));
        regiones.add(new Region("Los Ríos", 14));
        regiones.add(new Region("Arica y Parinacota", 15));
        regiones.add(new Region("Ñuble", 16));
    }

    public void leerTxt(String filepath) throws IOException {
        BufferedReader lectorLineas = new BufferedReader(new FileReader(filepath));
        String lineText = null;

        while( ((lineText = lectorLineas.readLine())) != null) {
            String[] tokens = lineText.split(",");
            Region region = this.regiones.get(Integer.parseInt(tokens[0])); // [0] = num region, [1] = nombre, [2] = rut, [3] = edad
            try {
                region.agregarPersona(tokens[1], tokens[2], Integer.parseInt(tokens[3]));
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }

        lectorLineas.close();
    }

    public void escribirTxt(String filepath) throws IOException {
        BufferedReader lectorLineas = new BufferedReader(new FileReader(filepath));
        String lineText = null;
        // usar getPersonas() y recorrer
        //(persona.getRegion().getNum() +","+ persona.getNombre() +","+ persona.getRut() +","+ persona.getEdad())
        lectorLineas.close();
    }

    public Region getRegion(int i) throws RegionException {
        if (i < 1 || i > regiones.size() + 1) throw new RegionException();
        return this.regiones.get(i - 1);
    }

    public Persona buscarPersona(String rut) {
        for (Region region : this.regiones) {
            Persona persona = region.buscarPersona(rut);
            if (persona != null) return persona;
        }
        return null;
    }

    public Vector<Persona> getPersonas() {
        Vector<Persona> personas = new Vector<>();
        // función que retorne vector de habitantes juntando cada getArray() de cada región
        return personas;
    }
}