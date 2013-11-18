package modele;

import metaModele.Attribut;
import metaModele.Configuration;
import metaModele.PortFourni;
import metaModele.PortRequis;

public class ClientHighPerf extends Client{

	public ClientHighPerf(String nom, Attribut attribut, PortRequis portRequis,
			PortFourni portFournis, ClientServeur clientServeur) {
		super(nom, attribut, portRequis, portFournis, clientServeur);
	}

	public ClientHighPerf(String nom, PortFourni portFournis,
			ClientServeur clientServeur) {
		super(nom, portFournis, clientServeur);
	}

}
