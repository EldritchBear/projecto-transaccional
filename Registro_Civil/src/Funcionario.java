
public class Funcionario extends Persona{
	private String funcion;
	
	public Funcionario(Region reg, String nom, String rutImportada, int edadImportada, String funcionImportada) {
		super(reg,nom,rutImportada,edadImportada);
		funcion = funcionImportada;
	}
	
	public void mostrarPersona() {
		System.out.println(getRegion());
		System.out.println(getNombre());
		System.out.println(getRut());
		System.out.println(getEdad());
		System.out.println(funcion);
	}
}
