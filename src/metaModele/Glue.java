package metaModele;

public class Glue {

	private RoleSortie roleSortie;
	private RoleEntree roleEntree;
	private Connecteur connecteur;
	
	public Glue(RoleSortie roleSortie, RoleEntree roleEntree) {
		super();
		this.roleSortie = roleSortie;
		this.roleEntree = roleEntree;
		roleSortie.definirPere(this);
		roleEntree.definirPere(this);
	}

	public void definirPere(Connecteur connecteur) {
		this.connecteur = connecteur;
	}
	
	
}
