package modele;

import metaModele.Attribut;
import metaModele.Composant;
import metaModele.PortFourni;
import metaModele.PortRequis;

public class Client extends Composant {

	public Client(String nom, Attribut attribut, PortRequis portRequis,
			PortFourni portFournis, ClientServeur clientServeur) {
		super(nom, attribut, portRequis, portFournis, clientServeur);
	}

	public Client(String nom, PortFourni portFournis, ClientServeur clientServeur) {
		super(nom, portFournis, clientServeur);
	}

}
