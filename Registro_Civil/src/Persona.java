

public class Persona {
	private String region;
	private String nombre;
	private String rut;
	private int edad;
	
	public Persona(String reg, String nom, String rutImportada, int edadImportada) {
		region = reg;
		nombre = nom;
		rut = rutImportada;
		edad = edadImportada;
	}
	
	public void MostrarPersona() {
		System.out.println(region);
		System.out.println(nombre);
		System.out.println(rut);
		System.out.println(edad);
	}
}