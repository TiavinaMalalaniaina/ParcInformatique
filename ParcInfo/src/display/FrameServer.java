package display;

import display.panel.BoxInfo;
import display.panel.PanelInfo;
import listener.ListenerServer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import socket.server.Server;


public class FrameServer extends JFrame {
//	FIELDS
	Server server;
	JPanel panelControl;
	JLabel appareilConnecte;
	PanelInfo panelInfo;
	JScrollPane scrollPanelInfo;
	
	
//	CONSTRUCTOR
	public FrameServer(Server server) throws IOException{
		super("Server");
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
	public JPanel getPanelControl()	{
		return panelControl;
	}
	public JLabel getAppareilConnecte() {
		return appareilConnecte;
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
	public void setPanelControl(JPanel panelControl) {
		this.panelControl = panelControl;
	}
	public void setAppareilConnecte(JLabel appareilConnecte) {
		this.appareilConnecte = appareilConnecte;
	}
	
	
//	DISPLAY
	public void display() throws IOException{
		this.setPanelInfo(new PanelInfo(getServer()));
		this.setPanelControl(new JPanel());
		this.setScrollPanelInfo(new JScrollPane(getPanelInfo()));
		this.setSize(1000, 800);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.addKeyListener(new ListenerServer(this));
		this.setFocusable(true);
		
		panelInfoSetting();
		panelControlSetting();
		scrollPanelInfoSetting();
	}
	public void panelControlSetting() {
		getPanelControl().setPreferredSize(new Dimension(250, 800));
		getPanelControl().setBackground(new Color(34, 87, 122));
		getPanelControl().setLayout(null);
		add(getPanelControl(), BorderLayout.WEST);
		
		setAppareilConnecte(new JLabel(String.valueOf(getPanelInfo().getBoxInfos().size()/2)));
		getAppareilConnecte().setFont(new Font("Arial", Font.BOLD, 102));
		getAppareilConnecte().setForeground(new Color(204, 255, 255));
		getAppareilConnecte().setBounds(100, 80, 260, 100);
		getPanelControl().add(getAppareilConnecte());
	}
	
	public void panelInfoSetting() throws IOException{
		getPanelInfo().setMinimumSize(new Dimension(750, 800));
		getPanelInfo().setPreferredSize(new Dimension(700, getServer().getThread().getSockets().size()*300));
		for (Socket socket : getServer().getThread().getSockets()) {
			getPanelInfo().getBoxInfos().add(new BoxInfo());
		}
	}
	public void scrollPanelInfoSetting() {
		getScrollPanelInfo().setBounds(0, 0, 800, 800);
		getScrollPanelInfo().setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.add(getScrollPanelInfo(), BorderLayout.CENTER);
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
