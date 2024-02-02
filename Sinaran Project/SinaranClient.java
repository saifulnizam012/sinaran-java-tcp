import java.io.*;
import java.net.*;
import javax.sound.sampled.*;

public class SinaranClient
{
	public static void main(String[] args) throws IOException
	{
		SinaranView sv = new SinaranView();
		String filepath = "bgm_sinaran.wav";
        playMusic(filepath);
		
		if(args.length != 2)
		{
			System.err.println("Hint: run by typing \" java SinaranClient <host name> <port number>\"");
	        System.exit(1);
		}
		
		String hostName = args[0];
		int portNumber = Integer.parseInt(args[1]);
		
		try (
				Socket sSocket = new Socket(hostName, portNumber);
				PrintWriter out = new PrintWriter(sSocket.getOutputStream(), true);
				BufferedReader in = new BufferedReader(new InputStreamReader(sSocket.getInputStream()));
			)
		{
			String fromServer;
			String fromUser;
			boolean waitUser = false;
			
			while (true)
			{
				if (waitUser == false)
				{
					fromServer = in.readLine();
					System.out.println("1");
					sv.txtrChat.append("\nServer: "+fromServer);
					if(fromServer.equals("Bye."))
						break;
					waitUser = true;
					sv.userResponded = false;
				}
				else
				{
					System.out.println("3");
					if (sv.userResponded)
					{
						System.out.println("2");
						fromUser = sv.userInput;
						sv.txtrChat.append("\nClient: "+fromUser);
		            	out.println(fromUser);
		            	waitUser = false;
					}
				}
				System.out.println("looping");
			}
			System.out.println("loopended");
		}
		catch (UnknownHostException e)
		{
			System.err.println("Don't know about host " + hostName);
            System.exit(1);
		}
		catch (IOException e)
		{
			System.err.println("Couldn't get I/O for the connection to " + hostName);
	        System.exit(1);
		}
	
	}

	public static void playMusic (String musicLocation){

		try {

			File musicPath = new File(musicLocation);

			if(musicPath.exists()){
				AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
				Clip clip = AudioSystem.getClip();
				clip.open(audioInput);
				clip.start();
				clip.loop(Clip.LOOP_CONTINUOUSLY);

			}else{
				System.out.println("Can't find this file");
			}


		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
