import java.net.*;
import java.io.*;

public class SinaranServer {

    public static void main(String [] args) throws IOException
    {
        if(args.length != 1)
        {
            System.err.println("Hint: run by typing \"SinaranServer <port number>\"");
            System.exit(1);
        }

        int portNumber = Integer.parseInt(args[0]);

        try(
            ServerSocket serverSocket = new ServerSocket(portNumber);
			Socket socket = serverSocket.accept();
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
		    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            )
        {
            String inputLine, outputLine;

            //initiate conversation with client
			SinaranProtocol sp = new SinaranProtocol();
			outputLine = sp.processInput(null);
			out.println(outputLine);
			
			while ((inputLine = in.readLine()) != null)
			{
				outputLine = sp.processInput(inputLine);
				out.println(outputLine);
				if (outputLine.equals("Jumpa Lagi Bye Bye."))
					break;
			}
		}
		catch (IOException e) 
		{
			System.out.println("Exception caught when trying to listen on port "+portNumber+" or listening for a connection");
	        System.out.println(e.getMessage());
		}
    }
        
}
