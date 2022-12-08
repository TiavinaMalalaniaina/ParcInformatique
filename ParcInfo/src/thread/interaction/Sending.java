package thread.interaction;

import java.io.PrintWriter;

import systeminfo.SystemInfo;

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
			System.out.println("Loading message ...");
			out.println(getMessage());
			out.flush();
			System.out.println("Message send");
			if(getMessage().equals("exit")) {
				out.close();
				break;
			}
			try {
				Thread.sleep(500);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		
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
