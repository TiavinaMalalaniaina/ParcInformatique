package socket.client;

import java.io.*;
import java.net.*;

import systeminfo.SystemInfo;
import thread.interaction.*;

public class Client {
//	FIELDS
	Socket socket = null;
	Sending threadSending;
	String message;
	
//	CONSTRUCTOR
	public Client(String address, int port) {
		try {
			setMessage("");
			System.out.println("Recherche du serveur");
			setSocket(new Socket(address, port));
			System.out.println("Connection avec le serveur établie");
			SystemInfo sys = new SystemInfo();
			setThreadSending(new Sending(new PrintWriter(getSocket().getOutputStream()), sys.getAllInfo()));
			getThreadSending().start();
			
		} catch(UnknownHostException e) {
			System.err.println("Impossible de se connecter à l'adresse "+getSocket().getLocalAddress());
		} catch (IOException e) {
			System.err.println("Aucun serveur trouvé sur le port "+getSocket().getLocalPort());
		}
	}
	
	
//	GETTER
	public Socket getSocket() {
		return socket;
	}
	public Sending getThreadSending() {
		return threadSending;
	}
	public String getMessage() {
		return message;
	}
//	SETTER
	public void setSocket(Socket socket) {
		this.socket = socket;
	}
	public void setThreadSending(Sending threadSending) {
		this.threadSending = threadSending;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	public static void main(String[] args) {
		Client c = new Client ("localhost", 4444);
	}
}

