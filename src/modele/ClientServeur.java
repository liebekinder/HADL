package modele;

import java.util.Set;

import metaModele.Configuration;
import metaModele.PortConfigurationFourni;
import metaModele.PortConfigurationRequis;

public class ClientServeur extends Configuration {

	public ClientServeur(String nom, PortConfigurationFourni portConfigurationFourni) {
		super(nom, portConfigurationFourni);
		// TODO Auto-generated constructor stub
	}

	public ClientServeur(String nom, PortConfigurationRequis portConfigurationRequis,
			PortConfigurationFourni portConfigurationFourni) {
		super(nom, portConfigurationRequis, portConfigurationFourni);
		// TODO Auto-generated constructor stub
	}



}
