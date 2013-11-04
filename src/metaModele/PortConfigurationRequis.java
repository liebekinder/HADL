package metaModele;

public class PortConfigurationRequis {

	private String nom;
	private BindingR bindingR;

	public PortConfigurationRequis(String nom) {
		super();
		this.nom = nom;
	}

	public void ajoutBinding(BindingR bindingR) {
		//TODO
		this.bindingR = bindingR;		
		
	}
	
}
