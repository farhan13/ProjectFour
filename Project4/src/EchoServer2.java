import java.net.*; 
import java.io.*; 

public class EchoServer2 extends Thread
{ 
 private Socket clientSocket;

 public static void main(String[] args) throws IOException 
   { 
	
    ServerSocket serverSocket = null; 
    
    // back-end stuff for server, create grid using 2d array
    
    int [][] board1 = new int[10][10];
    
    for (int x = 0; x<board1.length;x++){
   	   for (int y = 0; y<board1.length;y++){
   	      board1[x][y] = 0;  // Initialize the cell
   	   }
   	}
    //System.out.println("abcdef");
    
  // /*  // check by printing board
    
    for ( int x = 0; x<9;x++){
        String line = "";
        for ( int y = 0; y <9;y++){
            line+="["+board1[x][y]+"]";
        }
        System.out.println(line);
    }
    
     
   //  */
   
    // BOARD LOGIC
    
    /*	0 MEANS no ship, just water
     *  1 means Server ship/ player 1 ship position
     *  2 means Player 2 ship/ client ship position
     *  3 means player 1 hit position
     *  4 means player 2 hit position
     *  5 = player 1 miss positon
     *  6 = player 2 miss position
     * 	7 = player 1 ship + hit position
     *  8 = player 2 ship + hit position
     * 
     */

    try { 
         serverSocket = new ServerSocket(8080); 
         System.out.println ("Connection Socket Created");
         System.out.println ("Socket open on Port: " +
                             serverSocket.getLocalPort());
         InetAddress addr = InetAddress.getLocalHost();
         System.out.println("Java InetAddress localHost info: " + addr);
         System.out.println("Local Host Name: " + addr.getHostName());
         try { 
              while (true)
                 {
                  System.out.println ("Waiting for Connection");
                  new EchoServer2 (serverSocket.accept()); 
    
                  
                 }
             } 
         catch (IOException e) 
             { 
              System.err.println("Accept failed."); 
              System.exit(1); 
             } 
        } 
    catch (IOException e) 
        { 
         System.err.println("MSg 1: Could not listen on port: 12018."); 
         System.exit(1); 
        } 
    finally
        {
         try {
              serverSocket.close(); 
             }
         catch (Exception e)
             { 
              System.err.println("MSG 2: Could not close port: 12018."); 
              System.exit(1); 
             } 
        }

    

	    

    
    
    
   }

 private EchoServer2 (Socket clientSoc)
   {
    clientSocket = clientSoc;
    System.out.println ("Socket open on Port: " +
                             clientSocket.getLocalPort());
    System.out.println ("Socket open on Port: " +
                             clientSocket.getPort());
    start();
   }

 public void run()
   {
    System.out.println ("New Communication Thread Started");

    try { 
         PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), 
                                      true); 
         BufferedReader in = new BufferedReader( 
                 new InputStreamReader( clientSocket.getInputStream())); 

         String inputLine; 

         while ((inputLine = in.readLine()) != null) 
             { 
              System.out.println ("client: " + inputLine); 
              out.println(inputLine.toUpperCase()); 

              if (inputLine.equals("Bye.")) {
                  break; 
             } 
         
         	if ( inputLine.equals("hi")){
         		System.out.println ("hello from Server");
         	}
   }
         out.close(); 
         in.close(); 
         clientSocket.close(); 
        } 
    catch (IOException e) 
        { 
         System.err.println("Problem with Communication Server");
         System.exit(1); 
        } 
    }
 
 void sendBoard1 () {		// send the positions of the ships for player1
	 
	 
	 
 }

}


// back-end stuff for server, create grid using 2d array

	    

	    


