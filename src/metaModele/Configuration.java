package metaModele;

import java.util.HashSet;
import java.util.Set;

public class Configuration extends ComposantSupreme {

	private Set<PortConfigurationRequis> portConfigurationRequis;
	private Set<PortConfigurationFourni> portConfigurationFournis;
	private Set<Composant> composants;
	private Set<Connecteur> connecteurs;
	private Set<Configuration> configurations;

	public Configuration(String nom, PortConfigurationRequis portConfigurationRequis,
			PortConfigurationFourni portConfigurationFourni) {
		super(nom);
		this.portConfigurationRequis = new HashSet<>();
		ajoutPortConfigurationRequis(portConfigurationRequis);
		this.portConfigurationFournis = new HashSet<>();
		ajoutPortConfigurationFournis(portConfigurationFourni);
		composants = new HashSet<Composant>();
	}

	public Configuration(String nom, PortConfigurationFourni portConfigurationFourni) {
		this(nom, null, portConfigurationFourni);
	}

	private void ajoutComposant(Composant composant) {
		composants.add(composant);
	}

	private void ajoutConnecteur(Connecteur connecteur) {
		connecteurs.add(connecteur);
	}

	private void ajoutConfiguration(Configuration configuration) {
		configurations.add(configuration);
	}

	public void ajoutPortConfigurationFournis(
			PortConfigurationFourni portConfigurationFourni) {
		this.portConfigurationFournis.add(portConfigurationFourni);

	}

	public void ajoutPortConfigurationRequis(
			PortConfigurationRequis portConfigurationRequis) {
		this.portConfigurationRequis.add(portConfigurationRequis);
	}

}
