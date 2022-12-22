package display.panel;

import java.awt.Color;
import java.awt.Font;
import java.io.IOException;

import javax.swing.*;
import javax.swing.border.BevelBorder;

import systeminfo.SystemInfo2;

public class BoxInfo extends JPanel {
//	FIELDS
	SystemInfo2 systemInfo;
	JLabel labelUserName;
	JLabel labelOsName;
	JLabel labelRamMax;
	JLabel labelRamUsing;
	JLabel labelHostName;
	JLabel labelHostAddress;
	
//	CONSTRUCTOR
	public BoxInfo(SystemInfo2 systemInfo) {
		setSystemInfo(systemInfo);
		setLabelHostName(new JLabel(getSystemInfo().getHostName()));
		setlabelUserName(new JLabel("USER:"+getSystemInfo().getUsername()));
		setLabelOsName(new JLabel("OS:"+getSystemInfo().getOsname()));
		setLabelRamMax(new JLabel("RAM: "+getSystemInfo().getTotalMemorySize()+" go"));
		setLabelRamUsing(new JLabel("RAM-use: "+getSystemInfo().getUsingMemorySize()+" go"));
		setLabelHostAddress(new JLabel("Address IP:"+getSystemInfo().getHostAdress()));
		settingDisplay();
	}
	
	
	public BoxInfo() throws IOException {
		setSystemInfo(new SystemInfo2());
		setLabelHostName(new JLabel(getSystemInfo().getHostName()));
		setlabelUserName(new JLabel("USER: "+getSystemInfo().getUsername()));
		setLabelOsName(new JLabel("OS: "+getSystemInfo().getOsname()));
		setLabelRamMax(new JLabel("RAM: "+getSystemInfo().getTotalMemorySize()+"go"));
		setLabelRamUsing(new JLabel("RAM-use: "+getSystemInfo().getUsingMemorySize()+"go"));
		setLabelHostAddress(new JLabel("Address IP:"+getSystemInfo().getHostAdress()));
		settingDisplay();
	}
	
//	GETTER
	public SystemInfo2 getSystemInfo() {
		return systemInfo;
	}
	public JLabel getlabelUserName() {
		return labelUserName;
	}
	public JLabel getLabelOsName() {
		return labelOsName;
	}
	public JLabel getLabelRamMax() {
		return labelRamMax;
	}
	public JLabel getLabelRamUsing() {
		return labelRamUsing;
	}
	public JLabel getLabelHostName() {
		return labelHostName;
	}
	public JLabel getLabelHostAddress() {
		return labelHostAddress;
	}
	
//	SETTER
	public void setSystemInfo(SystemInfo2 systemInfo) {
		this.systemInfo = systemInfo;
	}
	public void setlabelUserName(JLabel labelUserName) {
		this.labelUserName = labelUserName;
	}
	public void setLabelOsName(JLabel labelOsName) {
		this.labelOsName = labelOsName;
	}
	public void setLabelRamMax(JLabel labelRamMax) {
		this.labelRamMax = labelRamMax;
	}
	public void setLabelRamUsing(JLabel labelRamUsing) {
		this.labelRamUsing = labelRamUsing;
	}
	public void setLabelHostName(JLabel labelHostName) {
		this.labelHostName = labelHostName; 
	}
	public void setLabelHostAddress(JLabel labelHostAddress) {
		this.labelHostAddress = labelHostAddress;
	}
	
	
	
	
//	DISPLAY
	public void settingDisplay() {
		setBounds(0,0, 700, 200);
		setBackground(new Color(45,153,155));
		getLabelHostName().setForeground(new Color(245, 255, 255));
		setLayout(null);
		setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

		
		getLabelHostName().setFont(new Font("Arial", Font.BOLD, 32));
		getLabelHostName().setBounds(20, 0, 300, 50);
		add(getLabelHostName());
		
		getlabelUserName().setFont(new Font("Arial", Font.PLAIN, 20));
		getlabelUserName().setBounds(450, 80, 300, 30);
		add(getlabelUserName());
		
		getLabelOsName().setFont(new Font("Arial", Font.PLAIN, 20));
		getLabelOsName().setBounds(80, 80, 300, 30);
		add(getLabelOsName());
	
		getLabelRamMax().setFont(new Font("Arial", Font.PLAIN, 20));
		getLabelRamMax().setBounds(80, 130, 300, 30);
		add(getLabelRamMax());

		getLabelRamUsing().setFont(new Font("Arial", Font.PLAIN, 20));
		getLabelRamUsing().setBounds(250, 130, 300, 30);
		add(getLabelRamUsing());
		
		
		getLabelHostAddress().setFont(new Font("Arial", Font.PLAIN, 20));
		getLabelHostAddress().setBounds(450, 130, 300, 30);
		add(getLabelHostAddress());
	}
	
	
	
	public static void main(String[] args) throws IOException{
		JFrame f = new JFrame();
		f.setSize(800, 300);
		f.setLayout(null);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		f.add(new BoxInfo());
		f.setVisible(true);
	}
}
