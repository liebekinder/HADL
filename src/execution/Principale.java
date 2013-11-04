package execution;

import modele.CodeSource;
import modele.BindingClientServeurF;
import modele.BindingClientServeurR;
import modele.Client;
import modele.ClientServeur;
import modele.GetResponse;
import modele.GetResponseConfiguration;
import modele.RequestClientServeurIN;
import modele.RequestClientServeurOUT;
import modele.SendRequest;
import modele.SendRequestConfiguration;
import modele.Visualisateur;


public class Principale {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SendRequestConfiguration sendResponseconfiguration = new SendRequestConfiguration("get response configuration"); 
		GetResponseConfiguration getResponseconfiguration = new GetResponseConfiguration("get response configuration");
		
		ClientServeur clientServeur = new ClientServeur("client serveur", sendResponseconfiguration);
		clientServeur.ajoutPortConfigurationRequis(getResponseconfiguration);
		
		
		SendRequest sendRequest = new SendRequest("send Request");
		GetResponse getResponse = new GetResponse("get Response");
		RequestClientServeurIN requestServeurIN = new RequestClientServeurIN("request serveur in");
		RequestClientServeurOUT requestServeurOUT = new RequestClientServeurOUT("request serveur out");
		Client client = new Client("client", sendRequest, clientServeur);
		client.ajoutPortRequis(getResponse);
		
		BindingClientServeurF bindingClientServeurF = new BindingClientServeurF(sendRequest, requestServeurOUT);
		BindingClientServeurR bindingClientServeurR = new BindingClientServeurR(getResponse, requestServeurIN);
		
		Visualisateur visualisateur = new Visualisateur();
		client.ajoutAttribut(visualisateur);
		CodeSource codeSource = new CodeSource();
		client.ajoutAttribut(codeSource);
		
		
		
		
		
		
		
	}

}
