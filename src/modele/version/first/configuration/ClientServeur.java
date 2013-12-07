package modele.version.first.configuration;

import metaModele.Configuration;
import metaModele.PortConfigurationFourni;
import metaModele.PortConfigurationRequis;

public class ClientServeur extends Configuration {

	public ClientServeur(String nom, PortConfigurationFourni portConfigurationFourni, ClientServeur luiMeme) {
		super(nom, portConfigurationFourni, null);
		// TODO Auto-generated constructor stub
	}

	public ClientServeur(String nom, PortConfigurationRequis portConfigurationRequis,
			PortConfigurationFourni portConfigurationFourni, ClientServeur luiMeme) {
		super(nom, portConfigurationRequis, portConfigurationFourni, null);
		// TODO Auto-generated constructor stub
	}



}
