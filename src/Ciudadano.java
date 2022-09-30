public class Ciudadano extends Persona{
	private boolean extranjero;
	
	public Ciudadano (Region reg, String nom, String rutImportada, int edadImportada, boolean esExtranjero) {
		super(reg,nom,rutImportada,edadImportada);
		extranjero = esExtranjero;
	}
	
	public void mostrarPersona() {
		System.out.println(getRegion());
		System.out.println(getNombre());
		System.out.println(getRut());
		System.out.println(getEdad());
		if(extranjero) {
			System.out.println("es extranjero");
		}
		else {
			System.out.println("es chileno");
		}
	}
}
