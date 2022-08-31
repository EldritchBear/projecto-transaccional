import java.util.*;

public class Region {
	private String nombre;
	private int habitantes;
	private Hashtable<String,Persona> ht = new Hashtable<>();
	
	
	public Region(String nom) {
		nombre = nom;
		habitantes = 0;
	}
	
	public void agregarPersona(String nom, String rut, int edad) {
		Persona a = new Persona(nombre,nom,rut,edad);
		ht.put(rut,a);
		habitantes++;
	}
	
	public Persona buscarPersona(String regionsaza, String rut) {
		
	}

}

