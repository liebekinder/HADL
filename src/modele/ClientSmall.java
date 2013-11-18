package modele;

import metaModele.Attribut;
import metaModele.Configuration;
import metaModele.PortFourni;
import metaModele.PortRequis;

public class ClientSmall extends Client{

	public ClientSmall(String nom, Attribut attribut, PortRequis portRequis,
			PortFourni portFournis, ClientServeur clientServeur) {
		super(nom, attribut, portRequis, portFournis, clientServeur);
	}

	public ClientSmall(String nom, PortFourni portFournis,
			ClientServeur clientServeur) {
		super(nom, portFournis, clientServeur);
	}

}
