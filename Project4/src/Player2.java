import java.io.*;
import java.net.*;

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

        System.out.println ("Player 2 connected, Type Message (\"Bye.\" to quit)");		// not necessary
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

