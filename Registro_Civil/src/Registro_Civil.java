import java.util.*;
import java.io.*;

public class Registro_Civil {

	public static void main(String[] args) throws IOException{
		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Region> regiones = new ArrayList<Region>(16);
		Persona persona;
		int csv;
		inicializarRegiones(regiones);
		leerTxt(regiones);
		
		

	}
	
	public static void leerTxt(ArrayList<Region> regiones) throws IOException {
		String filepath = "Registro.txt";
		BufferedReader lector_lineas = new BufferedReader(new FileReader(filepath));
		String lineText = null;
		
		while((lineText = lector_lineas.readLine()) != null) {
			String[] arr = lineText.split(",");
			Region aux = new Region(arr[0]);
			int i = regiones.indexOf(aux);
			aux = regiones.get(i);
			aux.agregarPersona(arr[0], arr[1], Integer.parseInt(arr[2]));
		}
		
		lector_lineas.close();
	}
	
	public static void inicializarRegiones(ArrayList<Region> regiones) {
		Region a = new Region("Tarapacá");
		regiones.add(a);
		a = new Region("Antofagasta");
		regiones.add(a);
		a = new Region("Atacama");
		regiones.add(a);
		a = new Region("Coquimbo");
		regiones.add(a);
		a = new Region("Valparaíso");
		regiones.add(a);
		a = new Region("Libertador General Bernardo O’Higgins");
		regiones.add(a);
		a = new Region("Maule");
		regiones.add(a);
		a = new Region("Biobío");
		regiones.add(a);
		a = new Region("La Araucanía");
		regiones.add(a);
		a = new Region("Los Lagos");
		regiones.add(a);
		a = new Region("Aysén del General Carlos Ibáñez del Campo");
		regiones.add(a);
		a = new Region("Magallanes y Antártica Chilena");
		regiones.add(a);
		a = new Region("Metropolitana de Santiago");
		regiones.add(a);
		a = new Region("Los Ríos");
		regiones.add(a);
		a = new Region("Arica y Parinacota");
		regiones.add(a);
		a = new Region("Ñuble");
		regiones.add(a);
	}
	
}
