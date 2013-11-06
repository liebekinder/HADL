package modele;

import metaModele.Attribut;
import metaModele.Configuration;
import metaModele.PortFourni;
import metaModele.PortRequis;

public class ClientSmall extends Client{

	public ClientSmall(String nom, Attribut attribut, PortRequis portRequis,
			PortFourni portFournis, Configuration configuration) {
		super(nom, attribut, portRequis, portFournis, configuration);
	}

	public ClientSmall(String nom, PortFourni portFournis,
			Configuration configuration) {
		super(nom, portFournis, configuration);
	}

}
