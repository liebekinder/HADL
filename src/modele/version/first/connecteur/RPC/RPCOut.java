package modele.version.first.connecteur.RPC;

import metaModele.Connecteur;
import metaModele.Glue;
import metaModele.RoleEntree;
import metaModele.RoleSortie;

public class RPCOut extends Glue{

	public RPCOut(RoleSortie roleSortie, RoleEntree roleEntree) {
		super(roleSortie, roleEntree);
	}

}
