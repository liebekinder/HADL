package execution;

import java.util.HashSet;
import java.util.Set;

import metaModele.Glue;
import modele.BindingClientServeurF;
import modele.BindingClientServeurR;
import modele.Client;
import modele.ClientCalled;
import modele.ClientCaller;
import modele.ClientServeur;
import modele.CodeSource;
import modele.GetResponse;
import modele.GetResponseConfiguration;
import modele.GetResponseFromClientCalled;
import modele.RPC;
import modele.RPCIn;
import modele.RPCOut;
import modele.ReceiveRequest;
import modele.ReceiveRequestFromServerCalled;
import modele.RequestClientServeurIN;
import modele.RequestClientServeurOUT;
import modele.SendRequest;
import modele.SendRequestConfiguration;
import modele.SendRequestToClientCaller;
import modele.SendResponse;
import modele.SendResponseToServerCaller;
import modele.ServerCalled;
import modele.ServerCaller;
import modele.Serveur;
import modele.Visualisateur;

public class Principale {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		RequestClientServeurIN requestServeurIN = new RequestClientServeurIN(
				"request serveur in");
		RequestClientServeurOUT requestServeurOUT = new RequestClientServeurOUT(
				"request serveur out");

		ClientServeur clientServeur = new ClientServeur("client serveur",
				requestServeurOUT);
		clientServeur.ajoutPortConfigurationRequis(requestServeurIN);

		// composant client avec ports principaux et ajout à la config
		SendRequest sendRequest = new SendRequest("send Request");
		GetResponse getResponse = new GetResponse("get Response");
		Client client = new Client("client", sendRequest, clientServeur);
		client.ajoutPortRequis(getResponse);

		// Ports pour bind avec configuration clientserveur
		SendRequestConfiguration sendResponseconfiguration = new SendRequestConfiguration(
				"send response configuration");
		GetResponseConfiguration getResponseconfiguration = new GetResponseConfiguration(
				"send response configuration");
		client.ajoutPortFourni(sendResponseconfiguration);
		client.ajoutPortRequis(getResponseconfiguration);

		// binding client vers configuration client serveur
		BindingClientServeurF bindingClientServeurF = new BindingClientServeurF(
				sendResponseconfiguration, requestServeurOUT);
		BindingClientServeurR bindingClientServeurR = new BindingClientServeurR(
				getResponseconfiguration, requestServeurIN);

		clientServeur.ajoutBindingF(bindingClientServeurF);
		clientServeur.ajoutBindingR(bindingClientServeurR);

		Visualisateur visualisateur = new Visualisateur();
		client.ajoutAttribut(visualisateur);
		CodeSource codeSource = new CodeSource();
		client.ajoutAttribut(codeSource);

		// role et glue IN/OUT
		ClientCaller clientCaller = new ClientCaller("client caller");
		ServerCalled serverCalled = new ServerCalled("serveur called");
		RPCIn rpcIn = new RPCIn(serverCalled, clientCaller);

		ClientCalled clientCalled = new ClientCalled("client called");
		ServerCaller serverCaller = new ServerCaller("serveur caller");
		RPCOut rpcOut = new RPCOut(clientCalled, serverCaller);

		// création du connecteur
		Set<Glue> setGlue = new HashSet<>();
		setGlue.add(rpcOut);
		setGlue.add(rpcIn);

		RPC rpc = new RPC("rpc", setGlue);
		clientServeur.ajoutConnecteur(rpc);

		// attachment entre rpc et client

		SendRequestToClientCaller sendRequestToClientCaller = new SendRequestToClientCaller(
				sendRequest, clientCaller);
		GetResponseFromClientCalled getResponseFromClientCalled = new GetResponseFromClientCalled(
				getResponse, clientCalled);
		
		clientServeur.ajoutAttachmentIN(sendRequestToClientCaller);
		clientServeur.ajoutAttachmentOUT(getResponseFromClientCalled);

		// serveur
		ReceiveRequest receiveRequest = new ReceiveRequest("receive request");
		SendResponse sendResponse = new SendResponse("send response");

		Serveur serveur = new Serveur("serveur", sendResponse, clientServeur);
		serveur.ajoutPortRequis(receiveRequest);

		// attachment entre serveur et rpc

		ReceiveRequestFromServerCalled receiveRequestFromServerCalled = new ReceiveRequestFromServerCalled(
				receiveRequest, serverCalled);
		SendResponseToServerCaller sendResponseToServerCaller = new SendResponseToServerCaller(
				sendResponse, serverCaller);

		clientServeur.ajoutAttachmentIN(sendResponseToServerCaller);
		clientServeur.ajoutAttachmentOUT(receiveRequestFromServerCalled);
		
		lancerExecution(clientServeur, requestServeurIN, "mon message");

	}

	private static void lancerExecution(ClientServeur clientServeur,
			RequestClientServeurIN requestServeurIN, String msg) {
		
		requestServeurIN.transmettreMessage(msg);
		
		
	}

}
