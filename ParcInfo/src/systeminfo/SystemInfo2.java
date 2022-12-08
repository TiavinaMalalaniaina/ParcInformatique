package systeminfo;

import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.net.UnknownHostException;

import com.sun.management.*;

public class SystemInfo2 {
//	FIELDS
	static OperatingSystemMXBean osBean =  (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
	
//	System
	String username;
	String osname;
	
//	SystemMXBean
	long committedVirtualMemorySize;
	double cpuLoad;
	long freeMemorySize;
	long freeSwapSpaceSize;
	double processCpuLoad;
	long processCpuTime;
	long totalMemorySize;
	long totalSwapSpaceSize;
	String hostAddress;
	String hostName;
	int availableProcessors;
	
//	CONSTRUCTOR
	public SystemInfo2() {
		this.setCommittedVirtualMemorySize(SystemInfo2.getCurrentCommitedVirtualMemorySize());
		this.setCpuLoad(SystemInfo2.getCurrentCpuLoad());
		this.setFreeMemorySize(SystemInfo2.getCurrentFreeMemorySize());
		this.setFreeSwapSpaceSize(SystemInfo2.getCurrentFreeSwapSpaceSize());
		this.setProcessCpuLoad(SystemInfo2.getCurrentCpuLoad());
		this.setProcessCpuTime(SystemInfo2.getCurrentProcessCpuTime());
		
	}
	
	
//	GETTER
	public OperatingSystemMXBean getOsBean() { return osBean; }
	public String getUsername() { return username; }
	public String getOsname() { return osname; }
	public long getCommittedVirtualMemorySize() { return committedVirtualMemorySize; }
	public double getCpuLoad() { return cpuLoad; }
	public long getFreeMemorySize() { return freeMemorySize; }
	public long getFreeSwapSpaceSize() { return freeSwapSpaceSize; }
	public double getProcessCpuLoad() { return processCpuLoad; }
	public long getProcessCpuTime() { return processCpuTime; }
	public long getTotalMemorySize() { return totalMemorySize; }
	public long getTotalSwapSpaceSize() { return totalSwapSpaceSize; }
 	public String getHostAdress() { return hostAddress; }
 	public String getHostName() { return hostName; }
 	public int getAvailableProcessors() { return availableProcessors; }
	
//	SETTER
	public void setUsername(String username) {this.username=username; }
	public void setOsname(String osname) { this.osname = osname; }
	public void setCommittedVirtualMemorySize(long committedVirtualMemorySize) { this.committedVirtualMemorySize=committedVirtualMemorySize; }
	public void setCpuLoad(double cpuLoad) { this.cpuLoad=cpuLoad; }
	public void setFreeMemorySize(long freeMemorySize) { this.freeMemorySize=freeMemorySize; }
	public void setFreeSwapSpaceSize(long freeSwapSpaceSize) { this.freeSwapSpaceSize=freeSwapSpaceSize; }
	public void setProcessCpuLoad(double processCpuLoad) { this.processCpuLoad=processCpuLoad; }
	public void setProcessCpuTime(long processCpuTime) { this.processCpuTime=processCpuTime; }
	public void setTotalMemorySize(long totalMemorySize) { this.totalMemorySize=totalMemorySize; }
	public void setTotalSwapSpaceSize(long totalSwapSpaceSize) { this.totalSwapSpaceSize=totalSwapSpaceSize; }
	public void setHostAddress(String hostAddress) { this.hostAddress=hostAddress; }
	public void setHostName(String hostName) { this.hostName=hostName; }
	public void setAvailableProcessors(int availableProcessors) { this.availableProcessors=availableProcessors; }
	
	
	public static String getCurrentUsername() { return System.getProperty("user.name"); }
	public static String getCurrentOsname() { return System.getProperty("os.name"); }
	public static long getCurrentCommitedVirtualMemorySize() { return osBean.getCommittedVirtualMemorySize(); }
	public static double getCurrentCpuLoad() { return osBean.getCpuLoad(); }
	public static long getCurrentFreeMemorySize() { return osBean.getFreeMemorySize(); }
	public static long getCurrentFreeSwapSpaceSize() { return osBean.getFreeSwapSpaceSize(); }
	public static double getCurrentProcessCpuLoad() { return osBean.getProcessCpuLoad(); }
	public static long getCurrentProcessCpuTime() { return osBean.getProcessCpuTime(); }
	public static long getCurrentTotalMemorysize() { return osBean.getTotalMemorySize(); }
	public static long getCurrentTotalSwapSpaceSize() { return osBean.getTotalSwapSpaceSize(); }
	public static String getCurrentHostAddress() throws UnknownHostException { return InetAddress.getLocalHost().getHostAddress(); }
	public static String getCurrentHostName() throws UnknownHostException { return InetAddress.getLocalHost().getHostName(); }
	public static int getcurrentAvailableProcessors() { return osBean.getAvailableProcessors(); }
	
	public static void main(String[] args) throws Exception{
		SystemInfo2 sys = new SystemInfo2();
		System.out.println(SystemInfo2.getCurrentHostAddress());
	}
}
