package listener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import display.FrameServer;
import display.panel.PanelInfo;

public class ListenerServer implements KeyListener, MouseListener {
//	FIELDS
	FrameServer frameServer;
	
//	CONSTRUCTOR
	public ListenerServer(FrameServer frameServer) {
		setFrameServer(frameServer);
	}
	
	@Override
	public void keyTyped(KeyEvent event) {
		
	}

	@Override
	public void keyPressed(KeyEvent event) {
		// TODO Auto-generated method stub
		switch(event.getExtendedKeyCode()) {
		case KeyEvent.VK_CONTROL:
			System.out.println("Actualiser");
			try {
				getFrameServer().setVisible(false);
				setFrameServer(new FrameServer(getFrameServer().getServer()));
				getFrameServer().setVisible(true);
//				getFrameServer().remove(frameServer.getPanelInfo());
//				getFrameServer().add(new PanelInfo(getFrameServer().getServer()));
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
		

	}

	@Override
	public void keyReleased(KeyEvent event) {
		// TODO Auto-generated method stub

	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
	public FrameServer getFrameServer() {
		return frameServer;
	}
	
//	SETTER
	public void setFrameServer(FrameServer frameServer) {
		this.frameServer = frameServer;
	}
}
