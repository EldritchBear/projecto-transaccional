import java.util.*;

public class Region {
	private String nombre;
	private int num;
	private HashMap<String,Persona> mapa = new HashMap<>();
	
	
	public Region(String nombre, int num) {
		this.num = num;
		this.nombre = nombre;
	}
	
	public void agregarPersona(String nombre, String rut, int edad) throws RutException {
		Persona persona = new Persona(this, nombre, rut, edad);
		if (persona.getRut().equals("invalido")) throw new RutException();
		mapa.put(persona.getRut(), persona);
	}

	public void agregarPersona(String nombre, String rut, int edad, String funcion, String extranjero) throws RutException {
		Persona persona;
		if (Objects.equals(funcion, "Ciudadano")) {
			persona = new Ciudadano(this, nombre, rut, edad, true);
		} else {
			persona = new Funcionario(this, nombre, rut, edad, funcion);
		}
		if (persona.getRut().equals("invalido")) throw new RutException();
		mapa.put(persona.getRut(), persona);
	}

	public void agregarPersona(Persona persona) {
		mapa.put(persona.getRut(), persona);
	}
	
	public void eliminarPersona(Persona persona) {
		eliminarPersona(persona.getRut());
	}
	
	public void eliminarPersona(String rut) {
		this.mapa.remove(rut);
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
		Persona[] array = mapa.values().toArray(new Persona[0]);
		return new ArrayList<>(List.of(array));
	}

	public int getNum() {
		return this.num;
	}
}