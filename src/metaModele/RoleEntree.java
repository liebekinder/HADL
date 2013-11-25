package metaModele;

public class RoleEntree {

	private String nom;
	private Glue glue;

	public RoleEntree(String nom) {
		super();
		this.nom = nom;
	}


	public void definirPere(Glue glue) {
		this.glue = glue;

	}
	
}
