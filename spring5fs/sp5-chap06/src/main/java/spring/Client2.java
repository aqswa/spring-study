package spring;

public class Client2{
	private String host;
	
	public void setHost(String host) {
		this.host = host;
	}
	
	public void connect() {
		System.out.println("Client2.afterProperties() 실행");
	}
	
	public void send() {
		System.out.println("Client2.send() to " + host);
	}
	
	public void close(){
		System.out.println("Client2.destroy() 실행");
	}
}