package modele;

import metaModele.AttachmentIN;
import metaModele.PortFourni;
import metaModele.RoleEntree;

public class SendRequestToClientCaller extends AttachmentIN{

	public SendRequestToClientCaller(PortFourni portFourni,
			RoleEntree roleEntree) {
		super(portFourni, roleEntree);
	}

}
