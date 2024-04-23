import java.rmi.*;
import java.net.*;
//import java.server.*;

public class Client{

	public static void main(String args[]){
		
		try{
			String url = "rmi://" + args[0] + "/Server";
		
			ServerIntf serverintf = (ServerIntf)Naming.lookup(url);
		
			System.out.println(serverintf.add(1, 2));
		}
		catch(Exception e){
		
			System.out.println(e);
		}
		
	}
}
