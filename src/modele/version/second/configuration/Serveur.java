package modele.version.second.configuration;

import execution.Mode;
import execution.Principale;
import metaModele.AttachmentIN;
import metaModele.AttachmentOUT;
import metaModele.BindingF;
import metaModele.BindingR;
import metaModele.Configuration;
import metaModele.PortConfigurationFourni;
import metaModele.PortConfigurationRequis;

public class Serveur extends Configuration{

	public Serveur(String nom, PortConfigurationFourni portConfigurationFourni,
			Configuration pere) {
		super(nom, portConfigurationFourni, pere);
	}

	//étrange
	public void nouveauMessage(GetTransferedMessage getTransferedMessage,
			String msg) {
		for(PortConfigurationRequis pR : portConfigurationRequis) {
			if(pR instanceof RequestIn) this.nouveauMessage(pR, msg);
		}
			
	}

	//étrange bis
	public void nouveauMessage(RequestOut requestOut, String msg) {
		for(PortConfigurationRequis pR : portConfigurationRequis) {
			if(pR instanceof SendTransfertMessage) this.composantPere.nouveauMessage(pR, msg);
		}
	}

	@Override
	public void afficherMessage(Object clazzObject, String msg)  {
		if(Principale.mode!=Mode.maxi) return;
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
