package metaModele;

public class PortFourni {

	private String nom;
	private BindingF bindingF;
	private AttachmentIN attachmentIN;

	public PortFourni(String nom) {
		super();
		this.nom = nom;
	}

	public void ajoutBinding(BindingF bindingF) {
		//TODO check bindingF
		this.bindingF = bindingF;
	}

	public void ajoutAttachment(AttachmentIN attachmentIN) {
		// TODO
		this.attachmentIN = attachmentIN;
		
	}
	
	
}
