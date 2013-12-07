package modele.version.second.configuration;

import metaModele.PortConfigurationFourni;

public class GetTransferedMessage extends PortConfigurationFourni{

	public GetTransferedMessage(String nom) {
		super(nom);
	}

	@Override
	public void transmettreMessage(String msg) {
		((Serveur)this.configuration).nouveauMessage(this,msg);
	}

}
