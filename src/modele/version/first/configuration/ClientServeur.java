package modele.version.first.configuration;

import metaModele.AttachmentIN;
import metaModele.AttachmentOUT;
import metaModele.BindingF;
import metaModele.BindingR;
import metaModele.Configuration;
import metaModele.PortConfigurationFourni;
import metaModele.PortConfigurationRequis;

public class ClientServeur extends Configuration {

	public ClientServeur(String nom, PortConfigurationFourni portConfigurationFourni, ClientServeur luiMeme) {
		super(nom, portConfigurationFourni, null);
	}

	public ClientServeur(String nom, PortConfigurationRequis portConfigurationRequis,
			PortConfigurationFourni portConfigurationFourni, ClientServeur luiMeme) {
		super(nom, portConfigurationRequis, portConfigurationFourni, null);
	}

	@Override
	public void afficherMessage(Object clazzObject, String msg)  {
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
