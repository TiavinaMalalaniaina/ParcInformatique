package listener.client;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import display.FrameClient;
import display.FrameClientConnected;
import socket.client.Client;

public class ListenerClient implements MouseListener {
//	FIELDS
	FrameClient frameClient;
	
	
//	CONSTRUCTOR
	public ListenerClient(FrameClient frameClient) {
		setFrameClient(frameClient);
	}
	
	@Override
	public void mouseClicked(MouseEvent event) {
		// TODO Auto-generated method stub
		try {
			if(event.getSource().equals(getFrameClient().getbuttonConnect())) {
				String ipAddress = getFrameClient().getTextFieldIP().getText();
				int port = Integer.parseInt(getFrameClient().getTextFieldPort().getText());
				FrameClientConnected f = new FrameClientConnected(new Client(ipAddress, port));
				f.setVisible(true);
				getFrameClient().setVisible(false);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

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
	public FrameClient getFrameClient() {
		return frameClient;
	}
	
//	SETTER
	public void setFrameClient(FrameClient frameClient) {
		this.frameClient = frameClient;
	}

}
