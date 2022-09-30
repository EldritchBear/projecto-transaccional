import java.util.*;

public class Region {
	private String nombre;
	private int num;
	private Hashtable<String,Persona> mapa = new Hashtable<>();
	
	
	public Region(String nombre, int num) {
		this.num = num;
		this.nombre = nombre;
	}
	
	public void agregarPersona(String nombre, String rut, int edad) throws RutException {
		Persona persona = new Persona(this, nombre, rut, edad);
		if (persona.getRut().equals("invalido")) throw new RutException();
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

	public ArrayList<Persona> getArray() {
		ArrayList<Persona> lista = new ArrayList<>();
		Object[] array = mapa.values().toArray();
		lista.addAll(Arrays.asList((Persona[]) array));
		return lista;
	}

	public int getNum() {
		return this.num;
	}
}