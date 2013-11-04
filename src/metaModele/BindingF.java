package metaModele;

public class BindingF {

	private PortFourni portFourni;
	private PortConfigurationFourni portConfigurationFourni;
	
	public BindingF(PortFourni portFourni,
			PortConfigurationFourni portConfigurationFourni) {
		super();
		this.portFourni = portFourni;
		this.portConfigurationFourni = portConfigurationFourni;
		portFourni.ajoutBinding(this);
		portConfigurationFourni.ajoutBinding(this);
	}
	
	
}
