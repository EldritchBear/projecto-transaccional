import java.util.*;

public class Region {
	private String nombre;
	private Hashtable<String,Persona> mapa = new Hashtable<>();
	
	
	public Region(String nombre) {
		this.nombre = nombre;
	}
	
	public void agregarPersona(String nombre, String rut, int edad) {
		Persona persona = new Persona(this, nombre, rut, edad);
		mapa.put(persona.getRut(), persona);
	}

	public void agregarPersona(Persona persona) {
		mapa.put(persona.getRut(), persona);
	}
	
	public Persona eliminarPersona(Persona persona) {
		return eliminarPersona(persona.getRut());
	}
	
	public Persona eliminarPersona(String rut) {
		return this.mapa.remove(rut);
	}
	
	public Persona buscarPersona(String rut) {
		return this.mapa.get(rut);
	}
	
	public int numHabitantes() {
		return this.mapa.size();
	}
	
	public String getNombre() {
		return this.nombre;
	}
	// cambiar el nombre de una región no es necesario, por lo tanto, no hay setter
}