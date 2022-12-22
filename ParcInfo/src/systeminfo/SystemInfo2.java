package systeminfo;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DecimalFormat;

import com.sun.management.*;

public class SystemInfo2 {
//	FIELDS
	static OperatingSystemMXBean osBean =  (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
	
//	System
	String username;
	String osname;
	
//	SystemMXBean
	String committedVirtualMemorySize;
	String cpuLoad;
	String freeMemorySize;
	String freeSwapSpaceSize;
	String processCpuLoad;
	String processCpuTime;
	String totalMemorySize;
	String totalSwapSpaceSize;
	String usingMemorySize;
	String usingSwapSpaceSize;
	String hostAddress;
	String hostName;
	int availableProcessors;
	
//	CONSTRUCTOR
	public SystemInfo2() throws IOException{
		this.setUsername(SystemInfo2.getCurrentUsername());
		this.setOsname(SystemInfo2.getCurrentOsname());
		this.setCommittedVirtualMemorySize(SystemInfo2.getCurrentCommitedVirtualMemorySize());
		this.setCpuLoad(SystemInfo2.getCurrentCpuLoad());
		this.setFreeMemorySize(SystemInfo2.getCurrentFreeMemorySize());
		this.setFreeSwapSpaceSize(SystemInfo2.getCurrentFreeSwapSpaceSize());
		this.setProcessCpuLoad(SystemInfo2.getCurrentCpuLoad());
		this.setProcessCpuTime(SystemInfo2.getCurrentProcessCpuTime());
		this.setTotalMemorySize(SystemInfo2.getCurrentTotalMemorySize());
		this.setTotalSwapSpaceSize(SystemInfo2.getCurrentTotalSwapSpaceSize());
		this.setUsingMemorySize(SystemInfo2.getCurrentUsingMemorySize());
		this.setUsingSwapSpace(SystemInfo2.getCurrentUsingSwapSpaceSize());
		this.setHostAddress(SystemInfo2.getCurrentHostAddress());
		this.setHostName(SystemInfo2.getCurrentHostName());
		this.setAvailableProcessors(SystemInfo2.getcurrentAvailableProcessors());
	}
	public SystemInfo2(String info) {
		String[] infos = info.split(";;");
		this.setUsername(infos[0]);
		this.setOsname(infos[1]);
		this.setCommittedVirtualMemorySize(infos[2]);
		this.setCpuLoad(infos[3]);
		this.setFreeMemorySize(infos[4]);
		this.setFreeSwapSpaceSize(infos[5]);
		this.setProcessCpuLoad(infos[6]);
		this.setProcessCpuTime(infos[7]);
		this.setTotalMemorySize(infos[8]);
		this.setTotalSwapSpaceSize(infos[9]);
		this.setUsingMemorySize(infos[10]);
		this.setUsingSwapSpace(infos[11]);
		this.setHostAddress(infos[12]);
		this.setHostName(infos[13]);
		this.setAvailableProcessors(Integer.parseInt(infos[14]));
		
	}
	
	
//	GETTER
	public OperatingSystemMXBean getOsBean() { return osBean; }
	public String getUsername() { return username; }
	public String getOsname() { return osname; }
	public String getCommittedVirtualMemorySize() { return committedVirtualMemorySize; }
	public String getCpuLoad() { return cpuLoad; }
	public String getFreeMemorySize() { return freeMemorySize; }
	public String getFreeSwapSpaceSize() { return freeSwapSpaceSize; }
	public String getProcessCpuLoad() { return processCpuLoad; }
	public String getProcessCpuTime() { return processCpuTime; }
	public String getTotalMemorySize() { return totalMemorySize; }
	public String getTotalSwapSpaceSize() { return totalSwapSpaceSize; }
	public String getUsingMemorySize() { return usingMemorySize; }
	public String getUsingSwapSpaceSize() { return usingSwapSpaceSize; }
 	public String getHostAdress() { return hostAddress; }
 	public String getHostName() { return hostName; }
 	public int getAvailableProcessors() { return availableProcessors; }
	
//	SETTER
	public void setUsername(String username) {this.username=username; }
	public void setOsname(String osname) { this.osname = osname; }
	public void setCommittedVirtualMemorySize(String committedVirtualMemorySize) { this.committedVirtualMemorySize=committedVirtualMemorySize; }
	public void setCpuLoad(String cpuLoad) { this.cpuLoad=cpuLoad; }
	public void setFreeMemorySize(String freeMemorySize) { this.freeMemorySize=freeMemorySize; }
	public void setFreeSwapSpaceSize(String freeSwapSpaceSize) { this.freeSwapSpaceSize=freeSwapSpaceSize; }
	public void setProcessCpuLoad(String processCpuLoad) { this.processCpuLoad=processCpuLoad; }
	public void setProcessCpuTime(String processCpuTime) { this.processCpuTime=processCpuTime; }
	public void setTotalMemorySize(String totalMemorySize) { this.totalMemorySize=totalMemorySize; }
	public void setTotalSwapSpaceSize(String totalSwapSpaceSize) { this.totalSwapSpaceSize=totalSwapSpaceSize; }
	public void setUsingMemorySize(String usingMemorySize) { this.usingMemorySize=usingMemorySize; }
	public void setUsingSwapSpace(String usingSwapSpaceSize) {this.usingSwapSpaceSize=usingSwapSpaceSize; }
	public void setHostAddress(String hostAddress) { this.hostAddress=hostAddress; }
	public void setHostName(String hostName) { this.hostName=hostName; }
	public void setAvailableProcessors(int availableProcessors) { this.availableProcessors=availableProcessors; }
	
	
//	GET THE SYSTEM INFO OF THE CURRENT PC
	public static String getCurrentUsername() { return System.getProperty("user.name"); }
	public static String getCurrentOsname() { return System.getProperty("os.name"); }
	public static String getCurrentCommitedVirtualMemorySize() { 
		DecimalFormat f = new DecimalFormat();
		f.setMaximumFractionDigits(2);
		return f.format((double)osBean.getCommittedVirtualMemorySize()/Math.pow(1024, 3)); 
	}
	public static String getCurrentCpuLoad() { 
		DecimalFormat f = new DecimalFormat();
		f.setMaximumFractionDigits(2);
		return f.format((double)osBean.getCpuLoad()/Math.pow(1024, 3)); 
	}
	public static String getCurrentFreeMemorySize() { 
		DecimalFormat f = new DecimalFormat();
		f.setMaximumFractionDigits(2);
		return f.format((double)osBean.getFreeMemorySize()/Math.pow(1024, 3)); 
	}
	public static String getCurrentFreeSwapSpaceSize() { 
		DecimalFormat f = new DecimalFormat();
		f.setMaximumFractionDigits(2);
		return f.format((double)osBean.getFreeSwapSpaceSize()/Math.pow(1024, 3)); 
	}
	public static String getCurrentProcessCpuLoad() { return String.valueOf(osBean.getProcessCpuLoad()); }
	public static String getCurrentProcessCpuTime() { 	
		DecimalFormat f = new DecimalFormat();
		f.setMaximumFractionDigits(2);
		return f.format((double)osBean.getProcessCpuTime()/Math.pow(1024, 3)); 
	}
	public static String getCurrentTotalMemorySize() { 
		DecimalFormat f = new DecimalFormat();
		f.setMaximumFractionDigits(2);
		return f.format((double)osBean.getTotalMemorySize()/Math.pow(1024, 3)); 
	}
	public static String getCurrentTotalSwapSpaceSize() { 
		DecimalFormat f = new DecimalFormat();
		f.setMaximumFractionDigits(2);
		return f.format((double)osBean.getTotalSwapSpaceSize()/Math.pow(1024, 3)); 
	 }
	public static String getCurrentUsingMemorySize() { 
		DecimalFormat f = new DecimalFormat();
		f.setMaximumFractionDigits(2);
		return f.format(((double)osBean.getTotalMemorySize()-osBean.getFreeMemorySize())/Math.pow(1024, 3)); 
	}
	public static String getCurrentUsingSwapSpaceSize() { 
		DecimalFormat f = new DecimalFormat();
		f.setMaximumFractionDigits(2);
		return f.format(((double)osBean.getTotalSwapSpaceSize()-osBean.getFreeSwapSpaceSize())/Math.pow(1024, 3)); 
	}
	public static String getCurrentHostAddress() throws UnknownHostException { return InetAddress.getLocalHost().getHostAddress(); }
	public static String getCurrentHostName() throws UnknownHostException { return InetAddress.getLocalHost().getHostName(); }
	public static int getcurrentAvailableProcessors() { return osBean.getAvailableProcessors(); }

	
	public String getAllInfo() {
		String info = "";
		info = info.concat(this.getUsername()+";;");
		info = info.concat(this.getOsname()+";;");
		info = info.concat(this.getCommittedVirtualMemorySize()+";;");
		info = info.concat(this.getCpuLoad()+";;");
		info = info.concat(this.getFreeMemorySize()+";;");
		info = info.concat(this.getFreeSwapSpaceSize()+";;");
		info = info.concat(this.getProcessCpuLoad()+";;");
		info = info.concat(this.getProcessCpuTime()+";;");
		info = info.concat(this.getTotalMemorySize()+";;");
		info = info.concat(this.getTotalSwapSpaceSize()+";;");
		info = info.concat(this.getUsingMemorySize()+";;");
		info = info.concat(this.getUsingSwapSpaceSize()+";;");
		info = info.concat(this.getHostAdress()+";;");
		info = info.concat(this.getHostName()+";;");
		info = info.concat(this.getAvailableProcessors()+"");
		return info;
	}
	
	
	public static void main(String[] args) {
		try {
			SystemInfo2 s = new SystemInfo2();
			System.out.println(s.getCurrentUsingMemorySize());
			
		}
		catch(IOException e ) {
			
		}
		
	}
}
