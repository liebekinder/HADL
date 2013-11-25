package metaModele;

public abstract class ComposantSupreme {

	private String nom;
	protected Configuration composantPere;
	
	public ComposantSupreme(String nom, Configuration pere){
		this.nom = nom;
		this.composantPere = pere;
	}
}
