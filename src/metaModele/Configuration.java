package metaModele;

import java.util.HashSet;
import java.util.Set;

import execution.Helper;

public class Configuration extends ComposantSupreme {

	protected Set<PortConfigurationRequis> portConfigurationRequis;
	protected Set<PortConfigurationFourni> portConfigurationFournis;
	protected Set<Composant> composants;
	protected Set<Connecteur> connecteurs;
	protected Set<Configuration> configurations;
	protected Set<BindingF> bindingF;
	protected Set<BindingR> bindingR;
	protected Set<AttachmentIN> attachmentIN;
	protected Set<AttachmentOUT> attachmentOUT;

	public Configuration(String nom, PortConfigurationRequis portConfigurationRequis,
			PortConfigurationFourni portConfigurationFourni,Configuration pere) {
		super(nom, pere);
		this.portConfigurationRequis = new HashSet<>();
		if(portConfigurationRequis!=null) ajoutPortConfigurationRequis(portConfigurationRequis);
		this.portConfigurationFournis = new HashSet<>();
		if(portConfigurationFourni!=null) ajoutPortConfigurationFournis(portConfigurationFourni);
		composants = new HashSet<Composant>();
		

		this.bindingF = new HashSet<>();
		this.bindingR = new HashSet<>();
		this.attachmentIN = new HashSet<>();
		this.attachmentOUT = new HashSet<>();
		this.connecteurs = new HashSet<>();
		this.configurations  = new HashSet<>();
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
		portConfigurationFourni.definirPere(this);

	}

	public void ajoutPortConfigurationRequis(
			PortConfigurationRequis portConfigurationRequis) {
		this.portConfigurationRequis.add(portConfigurationRequis);
		portConfigurationRequis.definirPere(this);
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
	

	public void nouveauMessage(
			PortConfigurationRequis portConfigurationRequis, String msg) {
		Helper.afficherMessage(this, msg);
		for(BindingR br: bindingR){
			if(br.getPortConfigurationRequis() == portConfigurationRequis){
				Helper.afficherMessage(this, "Binding utilisé !");
				br.getPortRequis().transmettreMessage(msg);
			}
		}
	}

	public void nouveauMessage(PortFourni portFourni, String msg) {
		Helper.afficherMessage(this, msg);
		for(BindingF bf: bindingF){
			if(bf.getPortFourni() == portFourni){
				Helper.afficherMessage(this, "Binding utilisé !");
				bf.getPortConfigurationFourni().transmettreMessage(msg);
			}
		}
		for(AttachmentIN ai: attachmentIN){
			if(ai.getPortFourni() == portFourni){
				ai.getRoleEntree().transmettreMessage(msg);
			}
		}
	}

	public void nouveauMessage(RoleSortie roleSortie, String msg) {
		Helper.afficherMessage(this, msg);
		for(AttachmentOUT ao: attachmentOUT){
			if(ao.getRoleSortie() == roleSortie){
				ao.getPortRequis().transmettreMessage(msg);
			}
		}
	}
	
	

}
