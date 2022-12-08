package thread.connection;

import java.io.*;
import java.net.*;
import thread.interaction.*;
import java.util.Vector;

public class ConnectServer extends Thread {
//	FIELDS
	private ServerSocket ss = null;
	private Vector<Socket> sockets = new Vector<Socket>();
	public Thread threadReceiving;
	
//	CONSTRUCTOR
	public ConnectServer(ServerSocket ss) {
		setServerSocket(ss);
	}
	
	@Override
	public void run() {
		try {
			while(true) {
				getSockets().add(getSs().accept());
				System.out.println("Un client s'est connecté au serveur");
				
				setThreadReceiving(new Receiving(getSockets().lastElement(),this));
				getThreadReceiving().start();
				
			}
		} catch( IOException e) {
			System.err.println("Le serveur ne réponds pas!!!");
		}
	}
	
	
//	GETTER
	public ServerSocket getSs() {
		return ss;
	}
	public Vector<Socket> getSockets() {
		return sockets;
	}
	public Thread getThreadReceiving() {
		return threadReceiving;
	}
	
//	SETTER
	public void setServerSocket(ServerSocket ss) {
		this.ss = ss;
	}
	public void setSockets(Vector<Socket> sockets) {
		this.sockets = sockets;
	}
	public void setThreadReceiving(Thread threadReceiving) {
		this.threadReceiving = threadReceiving;
	}
	
	
	
	

}
