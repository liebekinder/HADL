package modele.version.second.connecteur.CM_SM;

import java.util.Set;

import metaModele.Configuration;
import metaModele.Connecteur;
import metaModele.Glue;

public class CM_SM extends Connecteur{

	public CM_SM(String nom, Set<Glue> glues, Configuration pere) {
		super(nom, glues, pere);
	}

}
