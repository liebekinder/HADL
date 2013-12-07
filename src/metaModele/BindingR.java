package metaModele;

import execution.Helper;

public class BindingR {

	private PortRequis portRequis;
	private PortConfigurationRequis portConfigurationRequis;
	
	public BindingR(PortRequis portRequis,
			PortConfigurationRequis portConfigurationRequis) {
		super();
		this.portRequis = portRequis;
		this.portConfigurationRequis = portConfigurationRequis;
	}

	public PortConfigurationRequis getPortConfigurationRequis() {
		return portConfigurationRequis;
	}

	public PortRequis getPortRequis() {
		return portRequis;
	}	
	
	
}
