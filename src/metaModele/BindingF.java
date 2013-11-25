package metaModele;

import execution.Helper;

public class BindingF {

	private PortFourni portFourni;
	private PortConfigurationFourni portConfigurationFourni;
	
	public BindingF(PortFourni portFourni,
			PortConfigurationFourni portConfigurationFourni) {
		super();
		this.portFourni = portFourni;
		this.portConfigurationFourni = portConfigurationFourni;
	}

	public PortConfigurationFourni getPortConfigurationFourni() {
		Helper.afficherMessage(this, "Binding utilisé !");
		return portConfigurationFourni;
	}

	public PortFourni getPortFourni() {
		return portFourni;
	}
	
	
}
