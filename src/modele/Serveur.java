package modele;

import execution.Helper;
import metaModele.Attribut;
import metaModele.Composant;
import metaModele.PortFourni;
import metaModele.PortRequis;

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
			for(PortFourni pF : portFournis) if(pF instanceof SendResponse) pF.transmettreMessage("reponse: ton message \""+msg+"\" est un mouton (version courte)");
		}
	}

}
