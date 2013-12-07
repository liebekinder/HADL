package modele.version.second.composant.ConnexionManager;

import metaModele.Composant;
import metaModele.Configuration;
import metaModele.PortFourni;
import metaModele.PortRequis;

public class ConnexionManager extends Composant {

	public ConnexionManager(String nom, PortFourni portFournis,
			Configuration pere) {
		super(nom, portFournis, pere);
	}

	@Override
	public void nouveauMessage(PortRequis portRequis, String msg) {
		if(portRequis instanceof RequestIn) {
			for(PortFourni pF : portFournis) if(pF instanceof AskAutorization) pF.transmettreMessage(msg);
		}
		
		if(portRequis instanceof GetAutorization) {
			String[] smsg = msg.split("&");
			String authorization = smsg[smsg.length];
			if(!authorization.equals("true")) {
				for(PortFourni pF : portFournis) if(pF instanceof RequestOut) pF.transmettreMessage(msg);
			}
			else {
				for(PortFourni pF : portFournis) if(pF instanceof SendDBRequest) pF.transmettreMessage(smsg[2]);
			}
		}
	}

}
