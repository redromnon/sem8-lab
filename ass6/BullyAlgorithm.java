import java.util.Scanner;  

//create process class for creating a process having id and status  
class Process{  
   // declare variables  
   public int id;  
   public String status;  
     
   // initialize variables using constructor  
   public Process(int id){  
       //this.id = id;  
       this.status = "active";  
   }  
}  

public class BullyAlgorithm {

	// initialize variables and array  
    Scanner sc;  
    Process[] processes; 
    int[] processid; 
    int n;  
    
    // initialize Scanner class object in constructor  
    public BullyAlgorithm(){  
        sc= new Scanner(System.in);  
    }  
      
    // create ring() method for initializing the ring  
    public void ring(){  
          
        // get input from the user for processes  
        System.out.println("Enter total number of processes of Processes");  
        n = sc.nextInt();  
          
        // initialize processes array  
        processes = new Process[n];  
        for(int i = 0; i< n; i++){  
            processes[i]= new Process(i);  
        }  
        
        for(int i=0;i<n;i++)
        {
       	int pid;
       	processid= new int[n]; 
       	System.out.println("Enter the process id for process "+i+" ");
       	pid=sc.nextInt();
       	processid[i]=pid;
       	
        }
      
    }  
    
    
    // create election() method for electing process  
    public void performElection(){  
  
        int j=getMaxValue();
        System.out.println("\n"+j);
        System.out.println("Process having id "+processid[getMaxValue()]+" fails");  
          
        // change status to Inactive of the failed process  
        processes[getMaxValue()].status = "Inactive";  
          
        // declare and initialize variables   
        int idOfInitiator = getMaxValue()+1;  
        boolean overStatus = true;  
          
        // use while loop to repeat steps   
        while(overStatus){  
              
            boolean higherProcesses = false;  
            int prev_process_id=0;
            // iterate all the processes  
            for(int i = idOfInitiator; i< n; i++){  
                if(processes[i].status == "active"){  
                
                   if(processid[i]>=prev_process_id)
                   {
                   	 System.out.println("Process "+i+" Passes Election("+processid[i]+") message to process" +(i+1)); 
                   } 
                   else
                   {
                   	  System.out.println("Process "+i+" Passes Election("+prev_process_id+") message to process" +(i+1)); 
                   }
                   prev_process_id=processid[i];
                }  
            }  
              
            // check for higher process  
            if(higherProcesses){  
                  
                // use for loop to again iterate processes  
                for(int i = idOfInitiator + 1; i< n; i++){  
                    if(processes[i].status == "active"){  
                        System.out.println("Process "+i+"Passes Ok("+i+") message to process" +idOfInitiator);  
                    }  
  
                }  
                // increment initiator id   
                idOfInitiator++;  
            }  
  
            else{  
                // get the last process from the processes that will become coordinator  
                int coord = processes[getMaxValue()].id;  
                  
                // show process that becomes the coordinator  
                System.out.println("Finally Process "+coord+" Becomes Coordinator");  
                  
                  
                for(int i = coord - 1; i>= 0; i--){  
                    if(processes[i].status == "active"){  
                        System.out.println("Process "+coord+"Passes Coordinator("+coord+") message to process " +i);  
                    }  
                }  
                  
                  
                System.out.println("End of Election");  
                overStatus = false;  
                break;  
            }  
        }  
  
    }  
      
    // create getMaxValue() method that returns index of max process  
    public int getMaxValue(){  
        int mxId = -99;  
        int mxIdIndex = 0;  
        for(int i = 0; i<n; i++){  
            if(processes[i].status == "active" && processid[i] >mxId){  
                mxId = processid[i];  
                mxIdIndex = i;  
            }  
        }  
        return mxIdIndex;  
    }  
      
    // main() method start  
    public static void main(String[] args) {  
          
        // create instance of the BullyAlgoExample2 class  
    	BullyAlgorithm bully = new BullyAlgorithm();  
          
        // call ring() and performElection() method  
        bully.ring();  
        bully.performElection();  
  
    }  
	
}
