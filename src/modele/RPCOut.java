package modele;

import metaModele.Connecteur;
import metaModele.Glue;
import metaModele.RoleEntree;
import metaModele.RoleSortie;

public class RPCOut extends Glue{

	public RPCOut(RoleSortie roleSortie, RoleEntree roleEntree, Connecteur connecteur) {
		super(roleSortie, roleEntree, connecteur);
	}

}
