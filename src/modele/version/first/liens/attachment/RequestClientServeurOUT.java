package modele.version.first.liens.attachment;

import metaModele.PortConfigurationFourni;

public class RequestClientServeurOUT extends PortConfigurationFourni{

	public RequestClientServeurOUT(String nom) {
		super(nom);
	}

	@Override
	public void transmettreMessage(String msg) {
		configuration.afficherMessage(this, msg);
		//TODO sortie
		System.out.println("Vous avez un nouveau message : "+msg);
	}

}
