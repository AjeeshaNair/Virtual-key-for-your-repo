import java.util.Scanner; 
import java.util.Arrays;
import java.text.Collator;
import java.io.*;
import java.util.*;

class VirtualKey extends Fileaddition
{
	public void findFile(String name,File file)
    {
        File[] list = file.listFiles();
        if(list!=null)
        for (File fil : list)
        {
            if (fil.isDirectory())
            {
                findFile(name,fil);
            }
            else if (name.equals(fil.getName())) //Case sensitivity added
            {
                System.out.println(fil.getParentFile());
            }
            
            
            
            	
        }
    }
	//--------------------------------------------------------------------------
	
	
	public static void main(String[] args) throws IOException,FileNotFoundException {
		// Creating File Object 
				Fileaddition add = new Fileaddition(); 
				
		while(true) {
			
		
		System.out.println("\n**************************************\n");
        System.out.println("\tWelcome to LockedMe.com \n");
        System.out.println("\tDeveloped by:- Ajeesha S Nair, Teksystems Global Services Pvt Ltd \n");
        System.out.println("**************************************");
		
        System.out.println("Select one of the below operations to be performed");
        System.out.println(" 1. Display the file names in ascending order ");
        System.out.println(" 2. Add, delete or search a file ");
        System.out.println(" 3. Close the application ");
        Scanner sc =new Scanner(System.in);
        int options=sc.nextInt();
        switch (options) {
        case 1:
        	//Displaying the contents of a directory in ascending order 
        	BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 

    		System.out.println("Enter dirpath:"); 
    		String dirpath=br.readLine(); 
    		System.out.println("Enter the dirname"); 
    		String dname=br.readLine(); 

    		//create File object with dirpath and dname 
    		File f = new File(dirpath, dname); 

    		//if directory exists,then 
    		if(f.exists()) 
    		{ 
    			
    			String arr[]=f.list(); 

    			//find no. of entries in the directory 
    			int n=arr.length; 
    			Arrays.sort(arr, Collator.getInstance());

    			//displaying the entries 
    			for (int i = 0; i < n ; i++) { 
    				System.out.println(arr[i]); 
    				//create File object with the entry and test 
    				//if it is a file or directory 
    				File f1=new File(arr[i]); 
    				if(f1.isFile()) 
    					System.out.println(": is a file"); 
    				if(f1.isDirectory()) 
    					System.out.println(": is a directory"); 
    			} 
    			System.out.println("No of entries in this directory "+n); 
    		} 
    		else
    			System.out.println("Directory not found"); 
    		break;
   // ------------------------------------------------------------------------------------	
    	
        case 2:
        	System.out.println(" 1. Add a file to the existing directory list ");
            System.out.println(" 2. Delete a file from the existing directory list ");
            System.out.println(" 3. Search a file from the directory ");
            System.out.println(" 4. Navigate back to main directory ");
            
            Scanner rd =new Scanner(System.in);
            int choices=sc.nextInt();
            
            switch (choices) {
            case 1:
            	add.newFile();
            	
            	break;
            	
            case 2:
            	try  
            	{ BufferedReader bt = new BufferedReader( 
            	        new InputStreamReader(System.in)); 
            	    System.out.println("Enter the path of the file to be deleted :");
            		String ss= bt.readLine();

            		
            		File k = new File(ss);
            	       //file to be delete  
            	if(k.delete())                      //returns Boolean value  
            	{  
            	System.out.println(k.getName() + " deleted");   //getting and printing the file name  
            	}  
            	else  
            	{  
            	System.out.println("failed");  
            	}  
            	}  
            	 
                catch(IOException e)
                {
                      System.out.println("Exception Occurred : " + e);
                      System.out.println("File does not exist or deleted..!!");
                }
                break;
            	
            case 3:
            	VirtualKey ff = new VirtualKey();
                Scanner se = new Scanner(System.in);
                System.out.println("Enter the file to be searched.. " );
                String name = se.next();
                System.out.println("Enter the directory where to search ");
                String directory = se.next();
                System.out.println("File found at: -");
                ff.findFile(name,new File(directory));
                
                
                break;
                
            case 4:
            	//navigating back to the main screen
            	break;
            	
            
            	
            	
            }
            break;
            
     //----------------------------------------------------------------------------------   	
        case 3:
        	System.out.println("Application closing");
        	System.exit(0);
        	
        
     
        }
        
        
		    
		}
		
			} 
} 
