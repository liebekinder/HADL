package metaModele;

import java.util.HashSet;
import java.util.Set;

public class Composant extends ComposantSupreme {

	private Set<Attribut> attributs;
	private Set<PortRequis> portRequis;
	private Set<PortFourni> portFournis;

	public Composant(String nom, Attribut attribut, PortRequis portRequis,
			PortFourni portFournis,Configuration pere) {
		super(nom, pere);
		this.attributs = new HashSet<Attribut>();
		ajoutAttribut(attribut);
		
		this.portRequis = new HashSet<PortRequis>();
		ajoutPortRequis(portRequis);
		// assert portFournis != null && portFournis.length > 0 &&
		// portFournis[0] != null : "il doit y avoir au moins un PortFourni";
		this.portFournis = new HashSet<PortFourni>();
		ajoutPortFourni(portFournis);
	}

	public Composant(String nom, PortFourni portFournis,Configuration pere) {
		// TODO check this
		this(nom, null, null, portFournis, pere);
	}
	
	public void ajoutAttribut(Attribut attribut){
		attributs.add(attribut);
	}
	
	public void ajoutPortRequis(PortRequis portRequis){
		this.portRequis.add(portRequis);
		portRequis.definirPere(this);
	}

	public void ajoutPortFourni(PortFourni portFourni){
		this.portFournis.add(portFourni);
		portFourni.definirPere(this);
	}

	public void nouveauMessage(PortRequis portRequis2, String msg) {
				
	}

}
