package execution;

import metaModele.AttachmentIN;
import metaModele.AttachmentOUT;
import metaModele.BindingF;
import metaModele.BindingR;
import metaModele.Configuration;

public class Helper {
	public static void afficherMessage(Object clazzObject, String msg) {
		if(clazzObject instanceof BindingF || clazzObject instanceof BindingR || clazzObject instanceof AttachmentIN || clazzObject instanceof AttachmentOUT) {
			System.out.println("		"+clazzObject.getClass().getCanonicalName()+" -- \""+msg+"\" reçu. Transmission");
		}
		else if(clazzObject instanceof Configuration){
			System.out.println("	"+clazzObject.getClass().getCanonicalName()+" -- \""+msg+"\" reçu. Transmission");
		}
		else {
			System.out.println(clazzObject.getClass().getCanonicalName()+" -- \""+msg+"\" reçu. Transmission");
		}
		
	}
}
