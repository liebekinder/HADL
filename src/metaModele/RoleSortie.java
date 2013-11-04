package metaModele;

public class RoleSortie {

	private String nom;
	private AttachmentOUT attachmentOUT;

	public RoleSortie(String nom) {
		super();
		this.nom = nom;
	}
	
	public void ajoutAttachment(AttachmentOUT attachmentOUT) {
		// TODO
		this.attachmentOUT = attachmentOUT;
	}
	
	
}
