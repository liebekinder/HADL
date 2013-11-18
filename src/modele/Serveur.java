package modele;

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

}
