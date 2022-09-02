

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
	
	public String validarRut(String rut) {
		rut = rut.replaceAll("\\W", ""); // elimina carácteres especiales

		if (rut.length() < 1) return "invalido";
		
		String verif = rut.substring(rut.length() - 1);
		rut = rut.substring(0, rut.length() - 1);
		
		if (rut.length() == 8) {
			rut = rut.replaceAll("(^..)|(...)", "$1$2."); // agrega puntos
			return rut.substring(0, rut.length() - 1) + "-" + verif; // elimina el punto del final y agrega digito verificador
		}
		if (rut.length() == 7) {
			rut = rut.replaceAll("(^.)|(...)", "$1$2.");
			return rut.substring(0, rut.length() - 1) + "-" + verif;
		}
		return "invalido";
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String getRut() {
		return this.rut;
	}
	
	public String getRegion() {
		return this.region;
	}
	
	public int getEdad() {
		return this.edad;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setRut(String rut) {
		rut = validarRut(rut);
		System.out.println("Rut: " + rut);
		if (rut.equals("invalido")) {
			System.out.println("El rut introducido no es válido.");
			return;
		}
		this.rut = rut;
	}
	
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	// no se puede cambiar de región con sólo cambiar su variable, así que un setter sería inutil
	public void MostrarPersona() {
		System.out.println(region);
		System.out.println(nombre);
		System.out.println(rut);
		System.out.println(edad);
	}
}