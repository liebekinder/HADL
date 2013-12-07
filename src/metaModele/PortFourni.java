package metaModele;

import execution.Helper;

public class PortFourni {

	private String nom;
	protected Composant composant;

	public PortFourni(String nom) {
		super();
		this.nom = nom;
	}

	public void definirPere(Composant composant) {
		this.composant = composant;
	}

	public void transmettreMessage(String msg) {
		Helper.afficherMessage(this, msg);
		composant.getConfiguration().nouveauMessage(this, msg);
	}
	
	
}
