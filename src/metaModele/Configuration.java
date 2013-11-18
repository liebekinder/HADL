package metaModele;

import java.util.HashSet;
import java.util.Set;

public class Configuration extends ComposantSupreme {

	private Set<PortConfigurationRequis> portConfigurationRequis;
	private Set<PortConfigurationFourni> portConfigurationFournis;
	private Set<Composant> composants;
	private Set<Connecteur> connecteurs;
	private Set<Configuration> configurations;
	private Set<BindingF> bindingF;
	private Set<BindingR> bindingR;
	private Set<AttachmentIN> attachmentIN;
	private Set<AttachmentOUT> attachmentOUT;

	public Configuration(String nom, PortConfigurationRequis portConfigurationRequis,
			PortConfigurationFourni portConfigurationFourni,Configuration pere) {
		super(nom, pere);
		this.portConfigurationRequis = new HashSet<>();
		ajoutPortConfigurationRequis(portConfigurationRequis);
		this.portConfigurationFournis = new HashSet<>();
		ajoutPortConfigurationFournis(portConfigurationFourni);
		composants = new HashSet<Composant>();
		

		this.bindingF = new HashSet<>();
		this.bindingR = new HashSet<>();
		this.attachmentIN = new HashSet<>();
		this.attachmentOUT = new HashSet<>();
	}

	public Configuration(String nom, PortConfigurationFourni portConfigurationFourni,Configuration pere) {
		this(nom, null, portConfigurationFourni, pere);
	}

	public void ajoutComposant(Composant composant) {
		composants.add(composant);
	}

	public void ajoutConnecteur(Connecteur connecteur) {
		connecteurs.add(connecteur);
	}

	public void ajoutConfiguration(Configuration configuration) {
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
	
	public void ajoutBindingF(BindingF bf){
		bindingF.add(bf);
	}
	
	public void ajoutBindingR(BindingR br){
		bindingR.add(br);
	}
	
	public void ajoutAttachmentIN(AttachmentIN ai){
		attachmentIN.add(ai);
	}
	
	public void ajoutAttachmentOUT(AttachmentOUT ao){
		attachmentOUT.add(ao);
	}

}
