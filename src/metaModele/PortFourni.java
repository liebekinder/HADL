package metaModele;

public class PortFourni {

	private String nom;
	private Composant composant;

	public PortFourni(String nom) {
		super();
		this.nom = nom;
	}

	public void definirPere(Composant composant) {
		this.composant = composant;
	}
	
	
}
