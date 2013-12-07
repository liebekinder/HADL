package modele.version.first.composant.client;

import metaModele.Attribut;
import metaModele.Composant;
import metaModele.PortFourni;
import metaModele.PortRequis;
import modele.version.first.configuration.ClientServeur;
import modele.version.first.configuration.GetResponseConfiguration;
import modele.version.first.configuration.SendRequestConfiguration;

public class Client extends Composant {

	public Client(String nom, Attribut attribut, PortRequis portRequis,
			PortFourni portFournis, ClientServeur clientServeur) {
		super(nom, attribut, portRequis, portFournis, clientServeur);
	}

	public Client(String nom, PortFourni portFournis, ClientServeur clientServeur) {
		super(nom, portFournis, clientServeur);
	}

	@Override
	public void nouveauMessage(PortRequis portRequis, String msg) {
		composantPere.afficherMessage(this, msg);
		// TODO Auto-generated method stub
		if(portRequis instanceof GetResponseConfiguration) {
			for(PortFourni pR : portFournis) if(pR instanceof SendRequest) pR.transmettreMessage(msg);
		}
		if(portRequis instanceof GetResponse) {
			for(PortFourni pR : portFournis) if(pR instanceof SendRequestConfiguration) pR.transmettreMessage(msg);
		}
	}

}
