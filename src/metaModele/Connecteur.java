package metaModele;

import java.util.Set;

public class Connecteur extends ComposantSupreme {

	private Set<Glue> glues;

	public Connecteur(String nom, Set<Glue> glues, Configuration pere) {
		super(nom, pere);
		this.glues = glues;
	}

	public void ajoutGlue(Glue glue) {
		// TODO check glue
		glues.add(glue);
	}

}
