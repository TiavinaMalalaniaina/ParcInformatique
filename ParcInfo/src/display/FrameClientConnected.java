package display;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import listener.client.ListenerClientConnected;
import socket.client.Client;

public class FrameClientConnected extends JFrame {
//	FIELD
	Client client;
	JLabel labelTitle;
	JPanel panel;
	JButton buttonDisconnect;

//	CONSTRUCTOR
	public FrameClientConnected() {
		super("Client");
		setLabelTitle(new JLabel());
		setPanel(new JPanel());
		setButtonDisconnect(new JButton());
		displaySetting();
	}
	
	public FrameClientConnected(Client client) {
		setClient(client);
		setLabelTitle(new JLabel());
		setPanel(new JPanel());
		setButtonDisconnect(new JButton());
		displaySetting();
	}
	
	
//	DISPLAY
	public void displaySetting() {
		this.setLayout(null);
		this.setSize(600, 450);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		panelSetting();
		
	}
	
	public void panelSetting() {
		JPanel p = getPanel();
		p.setLayout(null);
		p.setBounds(0, 0, 600, 450);
		p.setBackground(new Color(34, 87, 122));
		
		labelTitleSetting();
		buttonDisconnectSetting();
		add(p);
	}
	
	public void labelTitleSetting() {
		JLabel l = getLabelTitle();
		l.setBounds(100,50,400,50);
		l.setFont(new Font("Tahoma", 0, 48));
        l.setForeground(new Color(204, 255, 255));
        l.setHorizontalAlignment(SwingConstants.CENTER);
        l.setText("CONNECTED");
		add(l);
	}
	
	public void buttonDisconnectSetting() {
		JButton b = getButtonDisconnect();
		b.setBounds(250, 300, 100, 35);
		b.setBackground(new Color(204, 255, 255));
        b.setFont(new Font("Tahoma", 0, 14)); 
        b.setText("DISCONNECT");
        b.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        b.addMouseListener(new ListenerClientConnected(this));
        
		getPanel().add(b);
	}
	
	
//	GETTER
	public Client getClient() {
		return client;
	}
	public JLabel getLabelTitle() {
		return labelTitle;
	}
	public JPanel getPanel() {
		return panel;
	}
	public JButton getButtonDisconnect() {
		return buttonDisconnect;
	}
	
//	SETTER
	public void setClient(Client client) {
		this.client = client;
	}
	public void setLabelTitle(JLabel labelTitle) {
		this.labelTitle = labelTitle;
	}
	public void setPanel(JPanel panel) {
		this.panel = panel;
	}
	public void setButtonDisconnect(JButton buttonDisconnect) {
		this.buttonDisconnect = buttonDisconnect;
	}
	
	
	
	public static void main(String[] args) {
		FrameClientConnected c = new FrameClientConnected(new Client("localhost", 4444));
		c.setVisible(true);
	}
}
