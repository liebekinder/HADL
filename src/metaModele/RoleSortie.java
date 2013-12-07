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

	public void transmettreMessage(String msg) {
		glue.getConfiguration().afficherMessage(this, msg);
		glue.getConfiguration().nouveauMessage(this,msg);
	}

}
