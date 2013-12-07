package modele.version.second.connecteur.CM_DB;

import java.util.Set;

import metaModele.Configuration;
import metaModele.Connecteur;
import metaModele.Glue;

public class CM_DB extends Connecteur{

	public CM_DB(String nom, Set<Glue> glues, Configuration pere) {
		super(nom, glues, pere);
	}

}
