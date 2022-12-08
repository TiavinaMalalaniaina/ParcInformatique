package display;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import listener.client.ListenerClient;

public class FrameClient extends JFrame {
//	FIELDS
	JLabel labelTitle;
	JPanel panel;
	JTextField textFieldIP;
	JTextField textFieldPort;
	JButton buttonConnect;
	
//	CONSTRUCTOR
	public FrameClient() {
		setLabelTitle(new JLabel());
		setPanel(new JPanel());
		setTextFieldIP(new JTextField());
		setTextFieldPort(new JTextField());
		setbuttonConnect(new JButton());
		displaySetting();
	}
	
//	DISPLAY
	//	SETTING DISPLAY FOR FRAME
		public void displaySetting() {
			this.setLayout(null);
			this.setSize(600, 450);
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			this.setLocationRelativeTo(null);
			this.setResizable(false);
			
			panelSetting();
		}
		
	
	//	SETTING DISPLAY FOR LABELTITLE
		public void labelTitleSetting() {
			JLabel l = getLabelTitle();
			l.setBounds(100,50,400,50);
			l.setFont(new Font("Tahoma", 0, 48)); // NOI18N
	        l.setForeground(new Color(204, 255, 255));
	        l.setHorizontalAlignment(SwingConstants.CENTER);
	        l.setText("Connect to Server");
			add(l);
			
		}
		
	
	//	SETTING DISPLAY FOR PANEL
		public void panelSetting() {
			JPanel p = getPanel();
			p.setLayout(null);
			p.setBounds(0, 0, 600, 450);
			p.setBackground(new Color(40,40,40));
			
			buttonConnectSetting();
			labelTitleSetting();
			textFieldIPSetting();
			textFieldPortSetting();
			add(p);
		}
		
	
	//	SETTING DISPLAY FOR TEXTFIELD IP
		public void textFieldIPSetting() {
			JTextField tf = getTextFieldIP();
			tf.setBounds(180, 220, 240, 50);
			tf.setBackground(new Color(204, 255, 255));
	        tf.setFont(new Font("Tahoma", 0, 18));
	        tf.setForeground(new Color(102,102,102));
	        tf.setHorizontalAlignment(JTextField.CENTER);
	        tf.setText("IP.ADDRESS");
	        
	        getPanel().add(tf);
		}
		
	//	SETTING DISPLAY FOR TEXTFIELD PORT
		public void textFieldPortSetting() {
			JTextField tf = getTextFieldPort();
			tf.setBounds(200, 150, 200, 50);
			tf.setBackground(new Color(204, 255, 255));
	        tf.setFont(new Font("Tahoma", 0, 18)); 
	        tf.setForeground(new Color(102,102,102));
	        tf.setHorizontalAlignment(JTextField.CENTER);
	        tf.setText("PORT");
	        
	        getPanel().add(tf);
		}
		
	
	//	SETTING DISPLAY FOR BUTTON CONNECT
		public void buttonConnectSetting() {
			JButton b = getbuttonConnect();
			b.setBounds(250, 300, 100, 35);
			b.setBackground(new Color(204, 255, 255));
	        b.setFont(new Font("Tahoma", 0, 14)); 
	        b.setText("CONNECT");
	        b.addMouseListener(new ListenerClient(this));
	        
			getPanel().add(b);
		}
	
//	GETTER
	public JLabel getLabelTitle() {
		return labelTitle;
	}
	public JPanel getPanel() {
		return panel;
	}
	public JTextField getTextFieldIP() {
		return textFieldIP;
	}
	public JTextField getTextFieldPort() {
		return textFieldPort;
	}
	public JButton getbuttonConnect() {
		return buttonConnect;
	}
	
//	SETTER
	public void setLabelTitle(JLabel labelTitle) {
		this.labelTitle = labelTitle;
	}
	public void setPanel(JPanel panel) {
		this.panel = panel;
	}
	public void setTextFieldIP(JTextField textFieldIP) {
		this.textFieldIP = textFieldIP;
	}
	public void setTextFieldPort(JTextField textFieldPort) {
		this.textFieldPort = textFieldPort;
	}
	public void setbuttonConnect(JButton buttonConnect) {
		this.buttonConnect = buttonConnect;
	}
	
	
	public static void main(String[] args) {
		FrameClient c = new FrameClient();
		c.setVisible(true);
	}
}
