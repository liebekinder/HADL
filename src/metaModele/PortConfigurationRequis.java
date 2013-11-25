package metaModele;

import java.util.Observable;

import execution.Helper;

public class PortConfigurationRequis{

	private String nom;
	private Configuration configuration;

	public PortConfigurationRequis(String nom) {
		super();
		this.nom = nom;
	}
	
	public void transmettreMessage(String msg){
		Helper.afficherMessage(this, msg);
		configuration.nouveauMessage(this,msg);
	}

	public void definirPere(Configuration configuration) {
		this.configuration = configuration;
		
	}
	
}
