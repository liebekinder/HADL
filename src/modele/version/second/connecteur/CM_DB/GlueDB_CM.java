package modele.version.second.connecteur.CM_DB;

import metaModele.Glue;
import metaModele.RoleEntree;
import metaModele.RoleSortie;

public class GlueDB_CM extends Glue{

	public GlueDB_CM(RoleSortie roleSortie, RoleEntree roleEntree) {
		super(roleSortie, roleEntree);
	}

}
