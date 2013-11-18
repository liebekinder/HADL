package modele;

import metaModele.Connecteur;
import metaModele.Glue;
import metaModele.RoleEntree;
import metaModele.RoleSortie;

public class RPCIn extends Glue{

	public RPCIn(RoleSortie roleSortie, RoleEntree roleEntree, Connecteur connecteur) {
		super(roleSortie, roleEntree, connecteur);
	}

}
