import java.util.*;
import java.io.*;

public class Registro_Civil {

	public static void main(String[] args) throws IOException{
		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Region> regiones = inicializarRegiones();
		
		leerTxt(regiones);
		
	}
	
	public static void leerTxt(ArrayList<Region> regiones) throws IOException {
		String filepath = "registro.txt";
		BufferedReader lectorLineas = new BufferedReader(new FileReader(filepath));
		String lineText = null;
		
		while( ((lineText = lectorLineas.readLine())) != null) {
			String[] tokens = lineText.split(",");
			Region region = regiones.get(Integer.parseInt(tokens[0]) - 1); // [0] = num region, [1] = nombre, [2] = rut, [3] = edad
			region.agregarPersona(tokens[1], tokens[2], Integer.parseInt(tokens[3]));
		}
		
		lectorLineas.close();
	}
	
	public static ArrayList<Region> inicializarRegiones() {
		ArrayList<Region> regiones = new ArrayList<Region>(16);
		regiones.add(new Region("Tarapacá"));
		regiones.add(new Region("Antofagasta"));
		regiones.add(new Region("Atacama"));
		regiones.add(new Region("Coquimbo"));
		regiones.add(new Region("Valparaíso"));
		regiones.add(new Region("Libertador General Bernardo O’Higgins"));
		regiones.add(new Region("Maule"));
		regiones.add(new Region("Biobío"));
		regiones.add(new Region("La Araucanía"));
		regiones.add(new Region("Los Lagos"));
		regiones.add(new Region("Aysén del General Carlos Ibáñez del Campo"));
		regiones.add(new Region("Magallanes y Antártica Chilena"));
		regiones.add(new Region("Metropolitana de Santiago"));
		regiones.add(new Region("Los Ríos"));
		regiones.add(new Region("Arica y Parinacota"));
		regiones.add(new Region("Ñuble"));
		return regiones;
	}
	
}
