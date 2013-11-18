package metaModele;

public abstract class ComposantSupreme {

	private String nom;
	private Configuration composantPere;
	
	public ComposantSupreme(String nom, Configuration pere){
		this.nom = nom;
		this.composantPere = pere;
	}
}
