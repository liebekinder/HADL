package modele.version.second.composant.DBManagement;

import metaModele.Composant;
import metaModele.Configuration;
import metaModele.PortFourni;
import metaModele.PortRequis;

public class DBManagement extends Composant{

	public DBManagement(String nom, PortFourni portFournis, Configuration pere) {
		super(nom, portFournis, pere);
	}

	@Override
	public void nouveauMessage(PortRequis portRequis, String request) {
		if(portRequis instanceof GetDBRequest) {
			String rmsg = "Invalid request.";
			if(request.equals("troll")) rmsg  = "toi même";
			for(PortFourni pF : portFournis) if(pF instanceof SendDBResponse) pF.transmettreMessage(rmsg);
		}
	}

}
