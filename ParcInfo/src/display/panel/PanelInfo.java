package display.panel;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

import socket.server.Server;
import systeminfo.SystemInfo;

public class PanelInfo extends JPanel {
//	FIELDS
	Server server;
	Vector<BoxInfo> boxInfos = new Vector<BoxInfo>();
	
//	CONSTRUCTOR
	public PanelInfo(Server server) throws IOException{
		setServer(server);
		display();
	}
	
	
//	GETTER
	public Server getServer() {
		return server;
	}
	public Vector<BoxInfo> getBoxInfos() {
		return boxInfos;
	}
	
//	SETTER
	public void setServer(Server server) {
		this.server = server;
	}
	public void setBoxInfos(Vector<BoxInfo> boxInfos) {
		this.boxInfos = boxInfos;
	}
	
	
//	DISPLAYING
	public void display() throws IOException{
		setBackground(new Color(50,50,50));
		setLayout(null);
		boxInfoSetting();
	}
	
	public void boxInfoSetting() throws IOException{
		for (int i = 0 ; i < getServer().getThread().getSockets().size() ; i++) {
			try {
				BufferedReader in = new BufferedReader(new InputStreamReader(getServer().getThread().getSockets().get(i).getInputStream()));
				BoxInfo boxInfo = new BoxInfo(new SystemInfo(in.readLine()));
				getBoxInfos().add(boxInfo);
				boxInfo.setBounds(10,(i*215)+10, 700, 200);
				add(boxInfo);
				setPreferredSize(new Dimension(800, 300*i));
			} catch(Exception e) {
				getServer().getThread().getSockets().remove(i);
			}
		}
	}
	
	

//	public static void main(String[] args) {
//		System.out.println(System.getProperty("user.name"));
//		JFrame f = new JFrame();
//		JPanel jp = new PanelInfo(new Server(5555));
//		JScrollPane js = new JScrollPane(jp);
//		js.setBounds(0, 0, 800, 800);
//		js.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//		f.setSize(800, 800);
//		f.setLayout(null);
//		f.setLocationRelativeTo(null);
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
//		f.add(js);
//		f.setVisible(true);
//	}
}
