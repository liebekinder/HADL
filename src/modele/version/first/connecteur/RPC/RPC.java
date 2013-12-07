package modele.version.first.connecteur.RPC;

import java.util.Set;

import metaModele.Connecteur;
import metaModele.Glue;
import modele.version.first.configuration.ClientServeur;

public class RPC extends Connecteur{

	public RPC(String nom, Set<Glue> glues, ClientServeur clientServeur) {
		super(nom, glues, clientServeur);
	}

}
