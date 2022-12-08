package socket.server;

import java.io.*;
import java.net.*;
import thread.connection.*;




public class Server{
//	FIELDS
	public ServerSocket ss = null;
	public ConnectServer thread;
	
//	CONSTRUCTOR
	public Server(int port) {
		try {
			ss = new ServerSocket(port);
			System.out.println("Serveur lancé sur le port "+ss.getLocalPort());
			setThread(new ConnectServer(getSS()));
			getThread().start();
		} 
		catch(IOException e) {
			System.err.println("Le port "+ss.getLocalPort()+" est deja utilisé!!!");
		}
	}
	
	
//	GETTER
	public ServerSocket getSS() {
		return ss;
	}
	public ConnectServer getThread() {
		return thread;
	}
	
//	SETTER
	public void setServerSocket(ServerSocket ss) {
		this.ss = ss;
	}
	public void setThread(ConnectServer thread) {
		this.thread = thread;
	}
	
	
	public static void main(String[] args) {
		new Server(4444);
		
	}
}
