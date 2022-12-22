package listener.client;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import display.FrameClientConnected;

public class ListenerClientConnected implements MouseListener {
//	FIELDS
	FrameClientConnected frameClient;
	
//	CONSTRUCTOR
	public ListenerClientConnected(FrameClientConnected frameClient) {
		setFrameClient(frameClient);
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent event) {
		if(getFrameClient().getButtonDisconnect().equals(event.getSource())) {
			getFrameClient().getClient().getThreadSending().setMessage("exit");
			getFrameClient().dispose();
			try {
				Thread.sleep(2000);
			}catch(InterruptedException e) {
				
			}
			System.exit(0);
		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	
	
//	GETTER
	public FrameClientConnected getFrameClient() {
		return frameClient;
	}
	
//	SETTER
	public void setFrameClient(FrameClientConnected frameClient) {
		this.frameClient = frameClient;
	}

}
