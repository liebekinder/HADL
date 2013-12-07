package metaModele;

public abstract class PortConfigurationFourni {

	protected String nom;
	protected Configuration configuration;

	public PortConfigurationFourni(String nom) {
		super();
		this.nom = nom;
	}

	public void definirPere(Configuration configuration) {
		this.configuration = configuration;
		
	}

	public abstract void transmettreMessage(String msg);
	
	
}
