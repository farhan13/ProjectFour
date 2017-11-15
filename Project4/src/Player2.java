import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class Player2 {
    public static void main(String[] args) throws IOException {

        Socket echoSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        int [][] board1 = new int[10][10];
        
        for (int x = 0; x<board1.length;x++){
       	   for (int y = 0; y<board1.length;y++){
       	      board1[x][y] = 0;  // Initialize the cell
       	   }
       	}
        
        String Player2Ship1 = "5,5";
        
       // int ShipPositions = 1;
        
        
        try {
            // echoSocket = new Socket("taranis", 7);
            echoSocket = new Socket("127.0.0.1", 8080);
            out = new PrintWriter(echoSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(
                                        echoSocket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: Battleship.");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for "
                               + "the connection to: BattleShip");
            System.exit(1);
        }

	BufferedReader stdIn = new BufferedReader(
                                   new InputStreamReader(System.in));
	String userInput;
	String ships;
	ArrayList<Coordinates> ship_coordinates = new ArrayList<Coordinates>;
	
    for (int a = 0; a<board1.length;a++){
    	   for (int b = 0; b<board1.length;a++){
    	      
    		   if(board1[a][b] == 1) {
    			   
    			   Coordinates coordinate = new Coordinates(a,b);
    			   
    			   ship_coordinates.add(coordinate);
    			   
    		   }     
    	   }
    	}
	

        System.out.println ("Player 2 connected, enter any key to start Battleship");		// not necessary
	while ((userInput = stdIn.readLine()) != null) 
           {
	    out.println(userInput);

            // end loop
            if (userInput.equals("Bye."))
                break;

	    System.out.println("Player2: " + in.readLine());			// not necessary
	   }
	
	
	
	
	
	out.close();
	in.close();
	stdIn.close();
	echoSocket.close();
    }
}

