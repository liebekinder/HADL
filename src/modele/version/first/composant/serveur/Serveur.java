package modele.version.first.composant.serveur;

import metaModele.Attribut;
import metaModele.Composant;
import metaModele.PortFourni;
import metaModele.PortRequis;
import modele.version.first.configuration.ClientServeur;
import execution.Helper;

public class Serveur extends Composant{

	public Serveur(String nom, Attribut attribut, PortRequis portRequis,
			PortFourni portFournis, ClientServeur clientServeur) {
		super(nom, attribut, portRequis, portFournis, clientServeur);
	}

	public Serveur(String nom, PortFourni portFournis,
			ClientServeur clientServeur) {
		super(nom, portFournis, clientServeur);
	}

	@Override
	public void nouveauMessage(PortRequis portRequis, String msg) {
		Helper.afficherMessage(this, msg);

		if(portRequis instanceof ReceiveRequest) {
			for(PortFourni pF : this.portFournis) {
				if(pF instanceof TransfertRequest) pF.transmettreMessage(msg);
			}
		}

		if(portRequis instanceof ReceiveResponseFromTransfert) {
			for(PortFourni pF : this.portFournis) {
				if(pF instanceof SendResponse) pF.transmettreMessage(msg);
			}
		}
	}

}
