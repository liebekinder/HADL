package modele.version.second.configuration;

import metaModele.PortConfigurationFourni;

public class RequestOut extends PortConfigurationFourni{

	public RequestOut(String nom) {
		super(nom);
	}

	@Override
	public void transmettreMessage(String msg) {
		((Serveur)this.configuration).nouveauMessage(this, msg);
	}

}
