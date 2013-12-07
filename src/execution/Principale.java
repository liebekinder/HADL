package execution;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import metaModele.AttachmentIN;
import metaModele.BindingF;
import metaModele.BindingR;
import metaModele.Glue;
import modele.version.first.composant.client.Client;
import modele.version.first.composant.client.CodeSource;
import modele.version.first.composant.client.GetResponse;
import modele.version.first.composant.client.SendRequest;
import modele.version.first.composant.client.Visualisateur;
import modele.version.first.composant.serveur.ReceiveRequest;
import modele.version.first.composant.serveur.ReceiveResponseFromTransfert;
import modele.version.first.composant.serveur.SendResponse;
import modele.version.first.composant.serveur.Serveur;
import modele.version.first.composant.serveur.TransfertRequest;
import modele.version.first.configuration.ClientServeur;
import modele.version.first.configuration.GetResponseConfiguration;
import modele.version.first.configuration.SendRequestConfiguration;
import modele.version.first.connecteur.RPC.ClientCalled;
import modele.version.first.connecteur.RPC.ClientCaller;
import modele.version.first.connecteur.RPC.RPC;
import modele.version.first.connecteur.RPC.RPCIn;
import modele.version.first.connecteur.RPC.RPCOut;
import modele.version.first.connecteur.RPC.ServerCalled;
import modele.version.first.connecteur.RPC.ServerCaller;
import modele.version.first.liens.attachment.GetResponseFromClientCalled;
import modele.version.first.liens.attachment.ReceiveRequestFromServerCalled;
import modele.version.first.liens.attachment.RequestClientServeurIN;
import modele.version.first.liens.attachment.RequestClientServeurOUT;
import modele.version.first.liens.attachment.SendRequestToClientCaller;
import modele.version.first.liens.attachment.SendResponseToServerCaller;
import modele.version.first.liens.binding.BindingClientServeurF;
import modele.version.first.liens.binding.BindingClientServeurR;
import modele.version.first.liens.binding.BindingFromInternConfig;
import modele.version.first.liens.binding.BindingToInternConfig;
import modele.version.second.composant.ConnexionManager.AskAutorization;
import modele.version.second.composant.ConnexionManager.ConnexionManager;
import modele.version.second.composant.ConnexionManager.GetAutorization;
import modele.version.second.composant.ConnexionManager.ReceiveDBResponse;
import modele.version.second.composant.ConnexionManager.SendDBRequest;
import modele.version.second.composant.DBManagement.DBManagement;
import modele.version.second.composant.DBManagement.GetDBRequest;
import modele.version.second.composant.DBManagement.SendDBResponse;
import modele.version.second.composant.SecurityManager.GetAccesRequest;
import modele.version.second.composant.SecurityManager.SecurityManager;
import modele.version.second.composant.SecurityManager.SendAccesResponse;
import modele.version.second.configuration.GetTransferedMessage;
import modele.version.second.configuration.RequestIn;
import modele.version.second.configuration.RequestOut;
import modele.version.second.configuration.SendTransfertMessage;
import modele.version.second.connecteur.CM_DB.CM_DB;
import modele.version.second.connecteur.CM_DB.CMcalledDB;
import modele.version.second.connecteur.CM_DB.CMcallerDB;
import modele.version.second.connecteur.CM_DB.DBcalledCM;
import modele.version.second.connecteur.CM_DB.DBcallerCM;
import modele.version.second.connecteur.CM_DB.GlueCM_DB;
import modele.version.second.connecteur.CM_DB.GlueDB_CM;
import modele.version.second.connecteur.CM_SM.CM_SM;
import modele.version.second.connecteur.CM_SM.CMcalledSM;
import modele.version.second.connecteur.CM_SM.CMcallerSM;
import modele.version.second.connecteur.CM_SM.GlueCM_SM;
import modele.version.second.connecteur.CM_SM.GlueSM_CM;
import modele.version.second.connecteur.CM_SM.SMcalledCM;
import modele.version.second.connecteur.CM_SM.SMcallerCM;
import modele.version.second.liens.attachment.AskAutorizationToCMcallerSM;
import modele.version.second.liens.attachment.CMcalledDBToGetDBRequest;
import modele.version.second.liens.attachment.CMcalledSMToGetAccesRequest;
import modele.version.second.liens.attachment.DBcalledCMToReceiveResponse;
import modele.version.second.liens.attachment.SMcalledCmTogetAutorization;
import modele.version.second.liens.attachment.SendAccessResponseToSMcallerCM;
import modele.version.second.liens.attachment.SendDBRequestToCMcallerDB;
import modele.version.second.liens.attachment.SendDBResponseToDBcallerCM;
import modele.version.second.liens.binding.RequestInToRequestIn;
import modele.version.second.liens.binding.RequestOutToRequestOut;

public class Principale {

	public static Mode mode = Mode.maxi;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
		//message : user&password&request
		
		
		
		
		//TODO: on ne peut ajouter le pere aux fils tant que les fils ne sont pas crées...
		//=> créer fils sans père et ajouter le père aux fils à l'initialisation
		RequestClientServeurIN requestServeurIN = new RequestClientServeurIN(
				"request serveur in");
		RequestClientServeurOUT requestServeurOUT = new RequestClientServeurOUT(
				"request serveur out");

		ClientServeur clientServeur = new ClientServeur("client serveur",
				requestServeurOUT,null);
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

		RPC rpc = new RPC("rpc", setGlue,clientServeur);
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
		/////////////////////////////////////////Seconde partie//////////////////////////////////////////////////
		
		//ajout de ports au serveur
		TransfertRequest transfertRequest = new TransfertRequest("transfert request");
		ReceiveResponseFromTransfert receiveResponseFromTransfert = new ReceiveResponseFromTransfert("receive response form transfert");
		
		serveur.ajoutPortRequis(receiveResponseFromTransfert);
		serveur.ajoutPortFourni(transfertRequest);
		
		
		//Config et ses ports
		
		RequestIn requestIn = new RequestIn("request in");
		RequestOut requestOut = new RequestOut("request out");
		GetTransferedMessage getTransferedMessage = new GetTransferedMessage("get transfered message");
		SendTransfertMessage sendTransfertMessage = new SendTransfertMessage("send transfered message");
		
		modele.version.second.configuration.Serveur serveurC = new modele.version.second.configuration.Serveur("Serveur config", requestOut, clientServeur);
		serveurC.ajoutPortConfigurationRequis(requestIn);
		serveurC.ajoutPortConfigurationFournis(getTransferedMessage);
		serveurC.ajoutPortConfigurationRequis(sendTransfertMessage);
	
		clientServeur.ajoutConfiguration(serveurC);
		
		//! Pas cool
		
		clientServeur.ajoutBindingR(new BindingFromInternConfig(receiveResponseFromTransfert, sendTransfertMessage));
		clientServeur.ajoutBindingF(new BindingToInternConfig(transfertRequest, getTransferedMessage));
		
		
		//Connexion manager
		
		modele.version.second.composant.ConnexionManager.RequestIn requestInC = new modele.version.second.composant.ConnexionManager.RequestIn("request in compo");
		modele.version.second.composant.ConnexionManager.RequestOut requestOutC = new modele.version.second.composant.ConnexionManager.RequestOut("request out compo");
		
		SendDBRequest sendDBRequest = new SendDBRequest("send DB request");
		ReceiveDBResponse receiveDBResponse = new ReceiveDBResponse("receive db response");
		
		GetAutorization getAutorization = new GetAutorization("get autorization");
		AskAutorization askAutorization = new AskAutorization("ask autorization");
		
		
		ConnexionManager connexionManager = new ConnexionManager("connexion manager", requestOutC, serveurC);
		connexionManager.ajoutPortRequis(requestInC);
		connexionManager.ajoutPortRequis(receiveDBResponse);
		connexionManager.ajoutPortRequis(getAutorization);
		connexionManager.ajoutPortFourni(sendDBRequest);
		connexionManager.ajoutPortFourni(askAutorization);
		
		serveurC.ajoutComposant(connexionManager);
		
		serveurC.ajoutBindingR(new RequestInToRequestIn(requestInC, requestIn));
		serveurC.ajoutBindingF(new RequestOutToRequestOut(requestOutC, requestOut));
		
		
		//connecteur CM-SM
		
		SMcalledCM sMcalledCM = new SMcalledCM("sm called cm");
		SMcallerCM sMcallerCM = new SMcallerCM("sm caller cm");
		GlueSM_CM glueSM_CM = new GlueSM_CM(sMcalledCM, sMcallerCM);
		
		CMcallerSM cMcallerSM = new CMcallerSM("cm caller SM");
		CMcalledSM cMcalledSM = new CMcalledSM("cm called SM");
		GlueCM_SM glueCM_SM = new GlueCM_SM(cMcalledSM, cMcallerSM);
		
		CM_SM cm_SM = new CM_SM("cm-sm", new HashSet<Glue>(Arrays.asList(glueCM_SM,glueSM_CM)), serveurC);
		serveurC.ajoutConnecteur(cm_SM);
		
		//connecteur CM-DB
		
		DBcalledCM DBcalledCM = new DBcalledCM("DB called cm");
		DBcallerCM DBcallerCM = new DBcallerCM("DB caller cm");
		GlueDB_CM glueDB_CM = new GlueDB_CM(DBcalledCM, DBcallerCM);
		
		CMcallerDB cMcallerDB = new CMcallerDB("cm caller DB");
		CMcalledDB cMcalledDB = new CMcalledDB("cm called DB");
		GlueCM_DB glueCM_DB = new GlueCM_DB(cMcalledDB, cMcallerDB);
		
		CM_DB cm_DB = new CM_DB("cm-DB", new HashSet<Glue>(Arrays.asList(glueCM_DB,glueDB_CM)), serveurC);
		serveurC.ajoutConnecteur(cm_DB);
		
		
		//Security manager
		SendAccesResponse sendAccesResponse = new SendAccesResponse("send acces response");
		GetAccesRequest getAccesRequest = new GetAccesRequest("get acces request");
		
		SecurityManager securityManager = new SecurityManager("security manager", sendAccesResponse, serveurC);
		securityManager.ajoutPortRequis(getAccesRequest);
		
		//DB manager
		GetDBRequest getDBRequest = new GetDBRequest("get db request");
		SendDBResponse sendDBResponse = new SendDBResponse("send db response");
		
		DBManagement dbManagement = new DBManagement("db management",sendDBResponse,serveurC);
		dbManagement.ajoutPortRequis(getDBRequest);
		
		//Attachments
		serveurC.ajoutAttachmentIN(new AskAutorizationToCMcallerSM(askAutorization, cMcallerSM));
		serveurC.ajoutAttachmentOUT(new CMcalledSMToGetAccesRequest(getAccesRequest, cMcalledSM));
		
		serveurC.ajoutAttachmentIN(new SendAccessResponseToSMcallerCM(sendAccesResponse, sMcallerCM));
		serveurC.ajoutAttachmentOUT(new SMcalledCmTogetAutorization(getAutorization, sMcalledCM));
		
		serveurC.ajoutAttachmentIN(new SendDBRequestToCMcallerDB(sendDBRequest, cMcallerDB));
		serveurC.ajoutAttachmentOUT(new CMcalledDBToGetDBRequest(getDBRequest, cMcalledDB));
		
		serveurC.ajoutAttachmentIN(new SendDBResponseToDBcallerCM(sendDBResponse, DBcallerCM));
		serveurC.ajoutAttachmentOUT(new DBcalledCMToReceiveResponse(receiveDBResponse, DBcalledCM));
		
			
		////////////////////////////////////////////////////fin seconde partie//////////////////////////////////////////
		

		// attachment entre serveur et rpc

		ReceiveRequestFromServerCalled receiveRequestFromServerCalled = new ReceiveRequestFromServerCalled(
				receiveRequest, serverCalled);
		SendResponseToServerCaller sendResponseToServerCaller = new SendResponseToServerCaller(
				sendResponse, serverCaller);

		clientServeur.ajoutAttachmentIN(sendResponseToServerCaller);
		clientServeur.ajoutAttachmentOUT(receiveRequestFromServerCalled);
		
		lancerExecution(clientServeur, requestServeurIN, "Ornicare&azerty&troll");

	}

	private static void lancerExecution(ClientServeur clientServeur,
			RequestClientServeurIN requestServeurIN, String msg) {
		
		requestServeurIN.transmettreMessage(msg);
		
		
	}

}
