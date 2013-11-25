package metaModele;

import execution.Helper;

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


	public void transmettreMessage(String msg) {
		Helper.afficherMessage(this, msg);
		glue.nouveauMessage(msg);
	}
	
}
