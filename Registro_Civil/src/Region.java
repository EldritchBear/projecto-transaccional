import java.util.*;

public class Region {
	private String nombre;
	private Hashtable<String,Persona> mapa = new Hashtable<>();
	
	
	public Region(String nombre) {
		this.nombre = nombre;
	}
	
	public void agregarPersona(String nombre, String rut, int edad) {
		Persona persona = new Persona(this.nombre, nombre, rut, edad);
		mapa.put(rut, persona);
	}
	
	public Persona buscarPersona(String rut) {
		return this.mapa.get(rut);
	}
	
	public int numHabitantes() {
		return this.mapa.size();
	}

}