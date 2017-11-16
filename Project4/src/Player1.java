import java.net.*;
import java.util.ArrayList;
import java.io.*; 

public class Player1 extends Thread
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
    
    for ( int x = 0; x<10;x++){
        String line = "";
        for ( int y = 0; y <10;y++){
            line+="["+board1[x][y]+"]";
        }
        System.out.println(line);
    }
    
    
    ArrayList ship_coordinates = new ArrayList<String_Coordinates>();
    
     
   //  */
   
    // BOARD LOGIC
    
    /*	0 MEANS no ship, just water
     *  10 means Server ship/ player 1 ship 1 position
     *  20 means Server ship/ player 1 ship 2 position
     *  30 means Server ship/ player 1 ship 3 position 
     *  40 means Server ship/ player 1 ship 4 position 
     *  50 means Server ship/ player 1 ship 5 position 
     *  2 means Player 2 ship/ client ship position
     *  3 means player 1 hit position
     *  4 means player 2 hit position
     *  5 = player 1 miss position
     *  6 = player 2 miss position
     * 	7 = player 1 ship + hit position
     *  8 = player 2 ship + hit position  // these 2 not useful
     * 
     */

    try { 
         serverSocket = new ServerSocket(8080); 
       //  System.out.println ("Connection Socket Created");		// not necessary
         System.out.println ("New Socket open on Port: " +
                             serverSocket.getLocalPort());
         InetAddress addr = InetAddress.getLocalHost();
         System.out.println("Java InetAddress localHost info: " + addr);
         System.out.println("Local Host Name: " + addr.getHostName());
         try { 
              while (true)
                 {
                  System.out.println ("Waiting for Player2...");
                  new Player1 (serverSocket.accept()); 
    
                  
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
         System.err.println("MSg 1: Could not listen on port: 8080."); 
         System.exit(1); 
        } 
    finally
        {
         try {
              serverSocket.close(); 
             }
         catch (Exception e)
             { 
              System.err.println("MSG 2: Could not close port: 8080."); 
              System.exit(1); 
             } 
        }

    

	    

    
    
    
   }

 private Player1 (Socket clientSoc)
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
    System.out.println ("Players connected. Begin BattleShip!");
    
   

    try { 
         PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), 
                                      true); 
         BufferedReader in = new BufferedReader( 
                 new InputStreamReader( clientSocket.getInputStream())); 

         String inputLine; 
         int num = 1;
         while ((inputLine = in.readLine()) != null) 
             { 
              System.out.println ("client: " + inputLine); 
              out.println(inputLine.toUpperCase()); 
              out.println("[1,0]");			// testing
              
              System.out.println(in.readLine());
              
              if (inputLine.equals("End")) {			// not necessary
                  break; 
             } 
              
              System.out.println("...");

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
 
 void sendShipPos () {		// send the positions of the ships for player1
	 
	 
	 
 }
 
 void sendFirePos () {		// send torpedo target location for player1
	 
	 
	 
 }

}


// back-end stuff to figure out: send ship positions, send target location -> hit / miss 
// convert to string, send via socket, receiver parses then retrieves data

	    

	    


