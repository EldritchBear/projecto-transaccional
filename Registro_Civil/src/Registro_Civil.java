import java.util.*;
import java.io.*;

public class Registro_Civil {

	public static void main(String[] args) throws IOException{
		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Region> regiones = inicializarRegiones();
		String nom;
		String rut;
		int edad;
		int i;
		Region region;
		Persona persona;
		
		leerTxt(regiones);
		
		while(true) {
			switch(leerMenu()) {
			case 0:
				break;
			case 1:
				System.out.println("ingrese el numero de la region a la que pertenece la persona");
				region = regiones.get(Integer.parseInt(lector.readLine()));
				System.out.println("ingrese la nombre de la persona");
				nom = lector.readLine();
				System.out.println("ingrese la rut de la persona");
				rut = lector.readLine();
				System.out.println("ingrese la edad de la persona");
				edad = Integer.parseInt(lector.readLine());
				region.agregarPersona(nom,rut,edad);
			case 2:
				i = 0;
				while(regiones.get(i) != null) {
					region = regiones.get(i);
					System.out.println("ingrese la rut de la persona que desea buscar");
					rut = lector.readLine();
					persona = region.buscarPersona(rut);
					if(persona == null) {
						i++;
					}
					else {
						System.out.println("se encontro a la persona");
						persona.MostrarPersona();
						break;
					}
				}
				
				if(persona == null) {
					System.out.println("la persona que usted busca no existe");
				}
			case 3:
				System.out.println("ingrese la rut de la persona que desea matar");
				rut = lector.readLine();
				persona.EliminarPersona(rut);
			}
			case 4:
				
			default:
				System.out.println("la opcion ingresada no existe");
		}
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
	
	public static int leerMenu() throws IOException{
		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Selecione una de las siguientes opciones");
		System.out.println("1. Agregar persona");
		System.out.println("2. Buscar persona");
		System.out.println("3. Matar persona");
		System.out.println("4. Numero de habitantes");
		System.out.println("0. salir");
		return Integer.parseInt(lector.readLine());
	}
}
