package systeminfo;

public class SystemInfo {
//	FIELDS
	String osName;
	String userName;
	long maxMemory;
	long usingMemory;
	
//	CONSTRUCTOR
	public SystemInfo() {
		setOsName(getCurrentOsName());
		setUserName(getCurrentUserName());
		setMaxMemory(getCurrentMaxMemory());
		setUsingMemory(getCurrentUsingMemory());
	}
	public SystemInfo(String info) {
		String[] infos = info.split(";;");
		setOsName(infos[0]);
		setUserName(infos[1]);
		setMaxMemory(Long.parseLong(infos[2]));
		setUsingMemory(Long.parseLong(infos[3]));
	}
	
	
//	GETTER
	public String getOsName() {
		return osName;
	}
	public String getUserName() {
		return userName;
	}
	public long getMaxMemory() {
		return maxMemory;
	}
	public long getUsingMemory() {
		return usingMemory;
	}
	
//	SETTER
	public void setOsName(String osName) {
		this.osName = osName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setMaxMemory(long maxMemory) {
		this.maxMemory = maxMemory;
	}
	public void setUsingMemory(long usingMemory) {
		this.usingMemory = usingMemory;
	}
	
	
	public String getCurrentOsName() {
		return System.getProperty("os.name");
	}
	
	public String getCurrentUserName() {
		return System.getProperty("user.name");
	}
	
	public String getCurrentOsVersion() {
		return System.getProperty("os.version");
	}
	
	public long getCurrentMaxMemory() {
		Runtime runtime = Runtime.getRuntime();
		return runtime.maxMemory()/1024/1024;
	}
	
	public long getCurrentFreeMemory() {
		Runtime runtime = Runtime.getRuntime();
		return runtime.freeMemory()/1024/1024;
	}
	
	public long getCurrentUsingMemory() {
		return (getCurrentMaxMemory() - getCurrentFreeMemory());
	}
	
	public String getAllInfo() {
		String info = "";
		info = info.concat(getOsName()+";;");
		info = info.concat(getUserName()+";;");
		info = info.concat(getMaxMemory()+";;");
		info = info.concat(getUsingMemory()+";;");
		return info;
	}
	
	
	public static void main(String[] args) {
		SystemInfo ss = new SystemInfo();
		System.out.println(ss.getAllInfo());
		System.out.println("*****");
	}
}