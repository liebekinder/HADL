package modele.version.second.configuration;

import metaModele.Configuration;
import metaModele.PortConfigurationFourni;
import metaModele.PortConfigurationRequis;

public class Serveur extends Configuration{

	public Serveur(String nom, PortConfigurationFourni portConfigurationFourni,
			Configuration pere) {
		super(nom, portConfigurationFourni, pere);
	}

	//étrange
	public void nouveauMessage(GetTransferedMessage getTransferedMessage,
			String msg) {
		for(PortConfigurationRequis pR : portConfigurationRequis) {
			if(pR instanceof RequestIn) this.nouveauMessage(pR, msg);
		}
			
	}

	//étrange bis
	public void nouveauMessage(RequestOut requestOut, String msg) {
		for(PortConfigurationRequis pR : portConfigurationRequis) {
			if(pR instanceof SendTransfertMessage) this.composantPere.nouveauMessage(pR, msg);
		}
	}

}
