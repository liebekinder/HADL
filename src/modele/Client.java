package modele;

import java.util.Set;

import metaModele.Attribut;
import metaModele.Composant;
import metaModele.Configuration;
import metaModele.PortFourni;
import metaModele.PortRequis;

public class Client extends Composant {

	public Client(String nom, Attribut attribut, PortRequis portRequis,
			PortFourni portFournis, Configuration configuration) {
		super(nom, attribut, portRequis, portFournis, configuration);
	}

	public Client(String nom, PortFourni portFournis, Configuration configuration) {
		super(nom, portFournis, configuration);
	}

}
