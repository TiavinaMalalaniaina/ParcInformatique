package display;

import display.panel.BoxInfo;
import display.panel.PanelInfo;
import listener.ListenerServer;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import socket.server.Server;


public class FrameServer extends JFrame {
//	FIELDS
	Server server;
	PanelInfo panelInfo;
	JScrollPane scrollPanelInfo;
	
	
//	CONSTRUCTOR
	public FrameServer(Server server) throws IOException{
		setServer(server);
		display();
	}
	
	
//	GETTER
	public Server getServer() {
		return server;
	}
	public PanelInfo getPanelInfo() {
		return panelInfo;
	}
	public JScrollPane getScrollPanelInfo() {
		return scrollPanelInfo;
	}
	
	
//	SETTER
	public void setServer(Server server) {
		this.server = server;
	}
	public void setPanelInfo(PanelInfo panelInfo) {
		this.panelInfo=panelInfo;
	}
	public void setScrollPanelInfo(JScrollPane scrollPanelInfo) {
		this.scrollPanelInfo = scrollPanelInfo;
	}
	
	
//	DISPLAY
	public void display() throws IOException{
		this.setSize(1000, 800);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setPanelInfo(new PanelInfo(getServer()));
		this.setScrollPanelInfo(new JScrollPane(getPanelInfo()));
		this.setLayout(new BorderLayout());
		this.add(getScrollPanelInfo(), BorderLayout.CENTER);
		this.addKeyListener(new ListenerServer(this));
		this.setFocusable(true);
	}
	
	public void panelInfoSetting() {
		getPanelInfo().setMinimumSize(new Dimension(800, 800));
		getPanelInfo().setPreferredSize(new Dimension(800, getServer().getThread().getSockets().size()*300));
		for (Socket socket : getServer().getThread().getSockets()) {
			getPanelInfo().getBoxInfos().add(new BoxInfo());
		}
	}
	public void scrollPanelInfoSetting() {
		getScrollPanelInfo().setBounds(0, 0, 800, 800);
		getScrollPanelInfo().setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	}
	
	
	
	public static void main(String[] args) {
		try {
			Server server = new Server(4444);
			JFrame frameServer = new FrameServer(server);
			frameServer.setVisible(true);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}
