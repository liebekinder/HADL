package metaModele;

import java.util.HashSet;
import java.util.Set;

public class Composant extends ComposantSupreme {

	private Set<Attribut> attributs;
	private Set<PortRequis> portRequis;
	private Set<PortFourni> portFournis;
	private Configuration configuration;

	public Composant(String nom, Attribut attribut, PortRequis portRequis,
			PortFourni portFournis, Configuration configuration) {
		super(nom);
		this.attributs = new HashSet<Attribut>();
		ajoutAttribut(attribut);
		
		this.portRequis = new HashSet<PortRequis>();
		ajoutPortRequis(portRequis);
		// assert portFournis != null && portFournis.length > 0 &&
		// portFournis[0] != null : "il doit y avoir au moins un PortFourni";
		this.portFournis = new HashSet<PortFourni>();
		ajoutPortFourni(portFournis);
		
		this.configuration = configuration;
	}

	public Composant(String nom, PortFourni portFournis, Configuration configuration) {
		// TODO check this
		this(nom, null, null, portFournis, configuration);
	}
	
	public void ajoutAttribut(Attribut attribut){
		attributs.add(attribut);
	}
	
	public void ajoutPortRequis(PortRequis portRequis){
		this.portRequis.add(portRequis);
	}

	public void ajoutPortFourni(PortFourni portFourni){
		this.portFournis.add(portFourni);
	}

}
