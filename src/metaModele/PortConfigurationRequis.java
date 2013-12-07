package metaModele;


public class PortConfigurationRequis{

	protected String nom;
	protected Configuration configuration;

	public PortConfigurationRequis(String nom) {
		super();
		this.nom = nom;
	}
	
	public void transmettreMessage(String msg){
		configuration.afficherMessage(this, msg);
		configuration.nouveauMessage(this,msg);
	}

	public void definirPere(Configuration configuration) {
		this.configuration = configuration;
		
	}
	
}
