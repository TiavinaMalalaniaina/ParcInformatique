package thread.interaction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import thread.connection.ConnectServer;

public class Receiving extends Thread {
//	FIELDS
	ConnectServer con;
	Socket socket;
	BufferedReader in;
	String message;
	
	
//	CONSTRUCTOR
	public Receiving(Socket socket, ConnectServer con) throws IOException{
		setCon(con);
		setSocket(socket);
		setIn(new BufferedReader(new InputStreamReader(getSocket().getInputStream())));
	}
	
	
	@Override
	public void run() {
		while(true){
	        try {	        	
				message = in.readLine();
				if(message.equals("exit")) {
					getSocket().close();
					getIn().close();
					getCon().getSockets().remove(getSocket());
					break;
				}
				System.out.println("Message:"+message);
			
		    } catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}

	
	
//	GETTER
	public Socket getSocket() {
		return socket;
	}
	public BufferedReader getIn() {
		return in;
	}
	public String getMessage() {
		return message;
	}
	public ConnectServer getCon() {
		return con;
	}
	
//	SETTER
	public void setSocket(Socket socket) {
		this.socket = socket;
	}
	public void setIn(BufferedReader in) {
		this.in = in;
	}
	public void setMessage(String message) { 	
		this.message = message;
	}
	public void setCon(ConnectServer con) {
		this.con = con;
	}
}
