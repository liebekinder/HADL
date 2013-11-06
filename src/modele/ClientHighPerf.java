package modele;

import metaModele.Attribut;
import metaModele.Configuration;
import metaModele.PortFourni;
import metaModele.PortRequis;

public class ClientHighPerf extends Client{

	public ClientHighPerf(String nom, Attribut attribut, PortRequis portRequis,
			PortFourni portFournis, Configuration configuration) {
		super(nom, attribut, portRequis, portFournis, configuration);
	}

	public ClientHighPerf(String nom, PortFourni portFournis,
			Configuration configuration) {
		super(nom, portFournis, configuration);
	}

}
