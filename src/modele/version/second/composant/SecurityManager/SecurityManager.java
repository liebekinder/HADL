package modele.version.second.composant.SecurityManager;

import java.util.HashMap;
import java.util.Map;

import metaModele.Composant;
import metaModele.Configuration;
import metaModele.PortFourni;
import metaModele.PortRequis;

public class SecurityManager extends Composant{

	private Map<String, String> authorizedUsers;

	public SecurityManager(String nom, PortFourni portFournis,
			Configuration pere) {
		super(nom, portFournis, pere);
		authorizedUsers = new HashMap<String,String>();
		authorizedUsers.put("Ornicare", "azerty");
	}

	@Override
	public void nouveauMessage(PortRequis portRequis, String msg) {
		if(portRequis instanceof GetAccesRequest) {
			String[] smsg = msg.split("&");
			String rmsg = msg;
			
			//denied
			if(smsg.length!=3 || !authorizedUsers.containsKey(smsg[0]) || !authorizedUsers.get(smsg[0]).equals(smsg[1])) {
				rmsg +="&false";
			}
			else {
				rmsg +="&true";
			}
			
			
			for(PortFourni pF : portFournis) {
				if(pF instanceof SendAccesResponse) {
					pF.transmettreMessage(rmsg);
				}
			}
				
		}
	}

}
