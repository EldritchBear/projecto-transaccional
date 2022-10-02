public class Ciudadano extends Persona{
	private boolean extranjero;
	
	public Ciudadano (Region reg, String nom, String rutImportada, int edadImportada, boolean esExtranjero) {
		super(reg,nom,rutImportada,edadImportada);
		extranjero = esExtranjero;
	}

	public Object[] getObjs() {
		String nacionalidad;
		if (extranjero) {
			nacionalidad = "Extranjero";
		} else {
			nacionalidad = "Chileno";
		}
		return new Object[]{this.getRegion().getNombre(), this.getNombre(), this.getRut(), this.getEdad(), "Ciudadano",
				nacionalidad};
	}
}
