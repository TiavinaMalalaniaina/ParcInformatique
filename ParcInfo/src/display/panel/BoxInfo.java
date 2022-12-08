package display.panel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
import javax.swing.border.AbstractBorder;

import systeminfo.SystemInfo;

public class BoxInfo extends JPanel {
//	FIELDS
	SystemInfo systemInfo;
	JLabel labelUserName;
	JLabel labelOsName;
	JLabel labelRamMax;
	JLabel labelRamUsing;
	
//	CONSTRUCTOR
	public BoxInfo(SystemInfo systemInfo) {
		setSystemInfo(systemInfo);
		setlabelUserName(new JLabel(getSystemInfo().getUserName()));
		setLabelOsName(new JLabel("OS:"+getSystemInfo().getOsName()));
		setLabelRamMax(new JLabel("RAM: "+getSystemInfo().getMaxMemory()+"go"));
		setLabelRamUsing(new JLabel("RAM-use: "+getSystemInfo().getCurrentUsingMemory()+"go"));
		settingDisplay();
	}
	
	
	public BoxInfo() {
		setSystemInfo(new SystemInfo());
		setlabelUserName(new JLabel(getSystemInfo().getUserName()));
		setLabelOsName(new JLabel("OS:"+getSystemInfo().getOsName()));
		setLabelRamMax(new JLabel("RAM: "+getSystemInfo().getMaxMemory()+"go"));
		setLabelRamUsing(new JLabel("RAM-use: "+getSystemInfo().getCurrentUsingMemory()+"go"));
		settingDisplay();
	}
	
//	GETTER
	public SystemInfo getSystemInfo() {
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
	
//	SETTER
	public void setSystemInfo(SystemInfo systemInfo) {
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
	
	
	
	
//	DISPLAY
	public void settingDisplay() {
		setBounds(0,0, 700, 200);
		setBackground(new Color(102,255,153));
		setLayout(null);
		
		
		getlabelUserName().setFont(new Font("Arial", Font.BOLD, 24));
		getlabelUserName().setBounds(20, 0, 300, 50);
		add(getlabelUserName());
		
		getLabelOsName().setFont(new Font("Arial", Font.PLAIN, 16));
		getLabelOsName().setBounds(100, 50, 300, 30);
		add(getLabelOsName());
	
		getLabelRamMax().setFont(new Font("Arial", Font.PLAIN, 16));
		getLabelRamMax().setBounds(100, 80, 300, 30);
		add(getLabelRamMax());

		getLabelRamUsing().setFont(new Font("Arial", Font.PLAIN, 16));
		getLabelRamUsing().setBounds(250, 80, 300, 30);
		add(getLabelRamUsing());
	}
	
	
	
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setSize(800, 300);
		f.setLayout(null);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		f.add(new BoxInfo());
		f.setVisible(true);
	}
}
