import java.net.*; 
import java.io.*; 

public class EchoServer2 extends Thread
{ 
 private Socket clientSocket;

 public static void main(String[] args) throws IOException 
   { 
    ServerSocket serverSocket = null; 

    try { 
         serverSocket = new ServerSocket(10008); 
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
         System.err.println("MSg 1: Could not listen on port: 10008."); 
         System.exit(1); 
        } 
    finally
        {
         try {
              serverSocket.close(); 
             }
         catch (Exception e)
             { 
              System.err.println("MSG 2: Could not close port: 10008."); 
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
              System.out.println ("Server: " + inputLine); 
              out.println(inputLine.toUpperCase()); 

              if (inputLine.equals("Bye.")) 
                  break; 
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
} 
