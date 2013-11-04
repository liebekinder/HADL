package metaModele;

public class RoleEntree {

	private String nom;
	private AttachmentIN attachmentIN;

	public RoleEntree(String nom) {
		super();
		this.nom = nom;
	}

	public void ajoutAttachment(AttachmentIN attachmentIN) {
		// TODO
		this.attachmentIN = attachmentIN;
		
	}
	
}
