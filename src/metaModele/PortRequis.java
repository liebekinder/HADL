package metaModele;


public class PortRequis {

	private String nom;
	Composant composant;

	public PortRequis(String nom) {
		super();
		this.nom = nom;
	}

	public void definirPere(Composant composant) {
		this.composant = composant;
	}

	public void transmettreMessage(String msg) {
		composant.getConfiguration().afficherMessage(this, msg);
		composant.nouveauMessage(this,msg);
		
	}
	
}
