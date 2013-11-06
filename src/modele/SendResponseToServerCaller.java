package modele;

import metaModele.AttachmentIN;
import metaModele.PortFourni;
import metaModele.RoleEntree;

public class SendResponseToServerCaller extends AttachmentIN {

	public SendResponseToServerCaller(PortFourni portFourni,
			RoleEntree roleEntree) {
		super(portFourni, roleEntree);
	}

}
