package thread.interaction;

import java.io.IOException;
import java.io.PrintWriter;

import systeminfo.SystemInfo;
import systeminfo.SystemInfo2;

public class Sending extends Thread {
//	FIELDS
	PrintWriter out;
	String message = "nope";
	
	public Sending(PrintWriter out) {
		setOut(out);
	}
	public Sending(PrintWriter out, String message) {
		setOut(out);
		setMessage(message);
	}
	@Override
	public void run() {
		while(true) {
			try {
				if(getMessage().equals("exit")) {
					sendMessage();
					break;
				} else {
					SystemInfo2 sys = new SystemInfo2();
					setMessage(sys.getAllInfo());
					sendMessage();
				}
				Thread.sleep(2000);
			} catch(InterruptedException | IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
//	SEND MESSAGE
	public void sendMessage() {
		System.out.println("Loading message ...");
		out.println(getMessage());
		out.flush();
		System.out.println("Message send");
	}
	
	
//	GETTER
	public PrintWriter getOut() {
		return out;
	}
	public String getMessage() {
		return message;
	}
	
//	SETTER
	public void setOut(PrintWriter out) {
		this.out = out;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
