package metaModele;

public class PortConfigurationFourni {

	private String nom;
	private Configuration configuration;

	public PortConfigurationFourni(String nom) {
		super();
		this.nom = nom;
	}

	public void definirPere(Configuration configuration) {
		this.configuration = configuration;
		
	}
	
	
}
