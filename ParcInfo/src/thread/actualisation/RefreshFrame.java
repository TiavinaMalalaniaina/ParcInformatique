package thread.actualisation;

import java.io.IOException;

import display.FrameServer;

public class RefreshFrame extends Thread {
//	FIELD
	FrameServer frameServer;
	
//	CONSTRUCTOR
	public RefreshFrame(FrameServer frameServer) {
		setFrameServer(frameServer);
	}
	
	
	public void run() {
		while(true) {
			try {
				FrameServer frameServer = new FrameServer(getFrameServer().getServer());
				Thread.sleep(2000);
				getFrameServer().setVisible(false);
				setFrameServer(frameServer);
				getFrameServer().setVisible(true);
			} catch(IOException | InterruptedException e) {}
		}
	}
	
//	GETTER
	public FrameServer getFrameServer() {
		return frameServer;
	}
	
//	SETTER
	public void setFrameServer(FrameServer frameServer) {
		this.frameServer = frameServer;
	}
	
	
	
}
