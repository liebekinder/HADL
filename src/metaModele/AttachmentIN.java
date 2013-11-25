package metaModele;

import execution.Helper;

public class AttachmentIN {

	private PortFourni portFourni;
	private RoleEntree roleEntree;
	
	public AttachmentIN(PortFourni portFourni, RoleEntree roleEntree) {
		super();
		this.portFourni = portFourni;
		this.roleEntree = roleEntree;
	}

	public PortFourni getPortFourni() {
		return portFourni;
	}
	
	public RoleEntree getRoleEntree() {
		Helper.afficherMessage(this, "Attachment utilisé !");
		return roleEntree;
	}
	
	
	
}
