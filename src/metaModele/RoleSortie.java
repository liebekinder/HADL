package metaModele;

public class RoleSortie {

	private String nom;
	private Glue glue;

	public RoleSortie(String nom) {
		super();
		this.nom = nom;
	}

	public void definirPere(Glue glue) {
		this.glue = glue;

	}

}
