package metaModele;

import java.util.HashSet;
import java.util.Set;

public class Connecteur extends ComposantSupreme {

	private Set<Glue> glues;

	public Connecteur(String nom, Set<Glue> glues, Configuration pere) {
		super(nom, pere);
		this.glues = new HashSet<>();
		ajoutGlue(glues);
	}

	public void ajoutGlue(Glue glue) {
		// TODO check glue
		glues.add(glue);
		glue.definirPere(this);
	}

	public void ajoutGlue(Set<Glue> glues) {
		for(Glue g: glues){
			ajoutGlue(g);
		}
	}

	public Configuration getConfiguration() {
		return composantPere;
	}
}
