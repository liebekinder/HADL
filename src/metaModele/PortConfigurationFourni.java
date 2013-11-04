package metaModele;

public class PortConfigurationFourni {

	private String nom;
	private BindingF bindingF;

	public PortConfigurationFourni(String nom) {
		super();
		this.nom = nom;
	}

	
	public void ajoutBinding(BindingF bindingF) {
		//TODO check bindingF
		this.bindingF = bindingF;
	}
	
	
}
