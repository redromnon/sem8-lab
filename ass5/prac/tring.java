class Node{

	int id;
	boolean token;

	Node(int id){
		this.id = id;
		this.token = false;
	}
	
	public void recieve(){
		this.token = true;
		System.out.println("Node "+id+" has recieved the token");
	}
	
	public void critical_section(){
		if(this.token){
			System.out.println("Node "+id+" has entered critical section");
		}

	}
	
	public void send(Node nextNode){
		this.token = false;
		System.out.println("Token passed to Node "+nextNode.id);
		nextNode.recieve();
	}

}


public class tring {

	public static void main(String[] args){
	
		Node[] nodes = new Node[5];
		
		for(int i = 0; i<5; i++){
			nodes[i] = new Node(i);
		}
		
		//Sender and Reciever
		int sender = 2;
		int reciever = 1;
		
		//Initiliaze sender
		nodes[sender].recieve();
		
		//Start loop
		for(int i = sender; i!=reciever; i=(i+1)%5){
			nodes[i].critical_section();
			nodes[i].send(nodes[(i+1)%5]);
		}
		
		//Final
		System.out.println("Hi");
		nodes[reciever].critical_section();
	
	}

}
