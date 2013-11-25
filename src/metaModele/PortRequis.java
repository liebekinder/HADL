package metaModele;

import execution.Helper;

public class PortRequis {

	private String nom;
	private Composant composant;

	public PortRequis(String nom) {
		super();
		this.nom = nom;
	}

	public void definirPere(Composant composant) {
		this.composant = composant;
	}

	public void transmettreMessage(String msg) {
		Helper.afficherMessage(this, msg);
		composant.nouveauMessage(this,msg);
		
	}
	
}
