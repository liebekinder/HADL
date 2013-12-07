package metaModele;


public class AttachmentOUT {

	private PortRequis portRequis;
	private RoleSortie roleSortie;
	
	public AttachmentOUT(PortRequis portRequis, RoleSortie roleSortie) {
		super();
		this.portRequis = portRequis;
		this.roleSortie = roleSortie;
	}

	public RoleSortie getRoleSortie() {
		return roleSortie;
	}

	public PortRequis getPortRequis() {
		portRequis.composant.getConfiguration().afficherMessage(this, "Attachment utilisé !");
		return portRequis;
	}
	
	
	
}
