
public class Funcionario extends Persona{
	private String funcion;
	
	public Funcionario(Region reg, String nom, String rutImportada, int edadImportada, String funcionImportada) {
		super(reg,nom,rutImportada,edadImportada);
		funcion = funcionImportada;
	}

	public Object[] getObjs() {
		return new Object[]{this.getRegion().getNombre(), this.getNombre(), this.getRut(), this.getEdad(), this.funcion,
				"Chileno"};
	}
}
