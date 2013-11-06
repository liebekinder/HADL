package modele;

import metaModele.Attribut;
import metaModele.Composant;
import metaModele.Configuration;
import metaModele.PortFourni;
import metaModele.PortRequis;

public class Serveur extends Composant{

	public Serveur(String nom, Attribut attribut, PortRequis portRequis,
			PortFourni portFournis, Configuration configuration) {
		super(nom, attribut, portRequis, portFournis, configuration);
	}

	public Serveur(String nom, PortFourni portFournis,
			Configuration configuration) {
		super(nom, portFournis, configuration);
	}

}
