public class Ciudadano extends Persona{
	private boolean extranjero;
	private int ingreso;
	
	public Ciudadano (Region reg, String nom, String rutImportada, int edadImportada, boolean esExtranjero, int ingreso) {
		super(reg,nom,rutImportada,edadImportada);
		extranjero = esExtranjero;
		this.ingreso = ingreso;
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
		System.out.println(ingreso);
	}
}
