package metaModele;

public class PortConfigurationRequis {

	private String nom;
	private Configuration configuration;

	public PortConfigurationRequis(String nom) {
		super();
		this.nom = nom;
	}
	
	public void transmettreMessage(String msg){
//		configuration.transmettreMessage(msg);
	}

	public void definirPere(Configuration configuration) {
		this.configuration = configuration;
		
	}
	
}
