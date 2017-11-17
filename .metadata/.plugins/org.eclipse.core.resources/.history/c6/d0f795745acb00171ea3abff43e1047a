import java.io.*;
import java.net.*;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class Player2 {

    public static void main(String[] args) throws IOException
    {
    	int x1,y1;
        Socket echoSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        int [][] board1 = new int[10][10];

        for (int x = 0; x<board1.length;x++){
            for (int y = 0; y<board1.length;y++){
                board1[x][y] = 0;  // Initialize the cell
            }
        }

        ArrayList<Coordinates> ship_coordinates = new ArrayList<Coordinates>();

        for (int a = 0; a<board1.length;a++){
            for (int b = 0; b<board1.length;b++){
                if(board1[a][b] == 1) {

                    Coordinates coordinate = new Coordinates(a,b);
                    ship_coordinates.add(coordinate);
                }
            }
        }

        ArrayList<String_Coordinates> ship_coordinates_s = new ArrayList<String_Coordinates>();
        for (int i = 0; i<ship_coordinates.size(); i++){
            String_Coordinates string_coordinates = new String_Coordinates(Integer.toString(ship_coordinates.get(i).getX()), Integer.toString(ship_coordinates.get(i).getY()));
            ship_coordinates_s.add(string_coordinates);
        }

        int size = ship_coordinates_s.size();
        System.out.println("size of string-coordinates:" + size);			// testing
        try {
            // echoSocket = new Socket("taranis", 7);
            echoSocket = new Socket("127.0.0.1", 8080);
            out = new PrintWriter(echoSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(
                    echoSocket.getInputStream()));

            DataOutputStream sending = new DataOutputStream(echoSocket.getOutputStream());


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
        String userInput = "23";
        String ships;


        battleshipCLIENT game = new battleshipCLIENT();

//        out.println(ship_coordinates_s.get(0).getX() + ship_coordinates_s.get(0).getY() + "\n");  // 1  5
        // out.println(ship_coordinates_s.get(0).getY() + "\n");		// 5

//        System.out.println("sending TO SERVER: " + ship_coordinates_s.get(0).getX() +" " + ship_coordinates_s.get(0).getY());		//testing
        x1 = game.x;
        y1 = game.y;
        String z = Integer.toString(x1);
        out.println(z);
        String inputLine = in.readLine();
        System.out.println ("Srart reading - Client");
        int i = 0;
//        while (inputLine != null){
        while ( i < 5){

            System.out.println("client received: " + inputLine);
            int rec = parseInt(inputLine);
            System.out.println("integer check: " + rec);
            // inputLine = null;
            i++;
        }
        System.out.println("Client done reading");

        out.close();
        in.close();
        stdIn.close();
        echoSocket.close();
    }
}

