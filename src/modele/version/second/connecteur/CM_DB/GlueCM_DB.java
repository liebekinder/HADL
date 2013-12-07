package modele.version.second.connecteur.CM_DB;

import metaModele.Glue;
import metaModele.RoleEntree;
import metaModele.RoleSortie;

public class GlueCM_DB extends Glue{

	public GlueCM_DB(RoleSortie roleSortie, RoleEntree roleEntree) {
		super(roleSortie, roleEntree);
	}

}
