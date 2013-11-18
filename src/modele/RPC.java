package modele;

import java.util.Set;

import metaModele.Connecteur;
import metaModele.Glue;

public class RPC extends Connecteur{

	public RPC(String nom, Set<Glue> glues, ClientServeur clientServeur) {
		super(nom, glues, clientServeur);
	}

}
