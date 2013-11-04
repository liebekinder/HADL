package metaModele;

public class PortRequis {

	private String nom;
	private BindingR bindingR;
	private AttachmentOUT attachmentOUT;

	public PortRequis(String nom) {
		super();
		this.nom = nom;
	}

	public void ajoutBinding(BindingR bindingR) {
		//TODO
		this.bindingR = bindingR;		
	}

	public void ajoutAttachment(AttachmentOUT attachmentOUT) {
		// TODO
		this.attachmentOUT = attachmentOUT;		
	}
	
}
