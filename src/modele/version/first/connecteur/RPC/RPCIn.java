package modele.version.first.connecteur.RPC;

import metaModele.Connecteur;
import metaModele.Glue;
import metaModele.RoleEntree;
import metaModele.RoleSortie;

public class RPCIn extends Glue{

	public RPCIn(RoleSortie roleSortie, RoleEntree roleEntree) {
		super(roleSortie, roleEntree);
	}

}
