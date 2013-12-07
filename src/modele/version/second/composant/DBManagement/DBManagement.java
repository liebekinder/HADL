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
	public void nouveauMessage(PortRequis portRequis, String msg) {
		// TODO Auto-generated method stub
		
	}

}
