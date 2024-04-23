import java.rmi.*;
//import java.server.*;
import java.net.*;

public class Server{

	public static void main(String args[]){
		try{
			ServerImpl serverimpl = new ServerImpl();
			Naming.rebind("Server", serverimpl);
		}
		catch(Exception e){
		
			System.out.println(e);
		}
	}
}
