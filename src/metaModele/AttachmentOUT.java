package metaModele;

import execution.Helper;

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
		Helper.afficherMessage(this, "Attachment utilisé !");
		return portRequis;
	}
	
	
	
}
