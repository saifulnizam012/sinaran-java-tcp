public class SinaranProtocol {
	private static final int WAITING = 0;
    private static final int START = 1;
    private static final int GUESS = 2;
    private static final int ANOTHER = 3;
    
    private static final int NUMROUNDS = 5;
    
    private int state = WAITING;
    private int currentRound = 0;
    
    private String[] tekateki = {"Kapal cargo bawak 300 batu bata, satu batu bata jatuh, tinggal berapa?", "Macam mana nak masukan gajah dalam peti ais?", "Macam mana nak masukan zirafah dalam peti ais?", "Tarzan buat party, semua haiwan datang, haiwan apa yang tak datang?", "Ali nak lintas sungai yang berbuaya, ada titi tapi patah, macam mana Ali nak lintas?","Ali lintas tapi mati jugak, kenapa?"};
    private String[] jawapan = {"299", "Bukak peti ais, masuk gajah, tutup peti ais", "Bukak peti ais, keluarkan gajah, masukan zirafah, tutup peti ais", "Zirafah, sebab duduk dalam peti ais", "Lintas je, buaya pergi party Tarzan","Batu bata dari kapal cargo jatuh kena kepala Ali"};
    
    public String processInput(String theInput)
    {
    	String theOutput = null;
    	if (state == WAITING)
    	{
			theOutput = "Hai Hai, Jom main teka teki dengan saya? :D";
    		state = START;
    	}
    	else if (state == START)
    	{
    		if (theInput.equalsIgnoreCase("Jom"))
    		{
    			theOutput = "Ini soalannya: "+ tekateki[currentRound];
    			state = GUESS;
    		}
    		else
    			theOutput = "awak kene la cakap \"jom\" dulu";
    	}
    	else if (state == GUESS)
    	{
    		if (theInput.equalsIgnoreCase("Tak tau"))
    		{
    			theOutput ="jawapan dia: "+jawapan[currentRound]+" , nak teka teki lagi??? kalau nak cakap \"Nak\" :D";
    			state = ANOTHER;
    		}
    		else
    		{
    			theOutput = "Awak cuma perlu cakap \"Tak tau\"!, jom sambung  >_<";
    			state = START;
    		}
    	}
    	else if (state == ANOTHER)
    	{
    		if (theInput.equalsIgnoreCase("Nak"))
    		{
    			theOutput = "Jom main :D";
    			
    			if (currentRound == (NUMROUNDS - 1))
    				currentRound = 0;
    			else
    				currentRound++;
    			
    			state = START;
    		}
    		else 
    		{
    			theOutput = "Jumpa lagi bye bye.";
    			state = WAITING;
    		}
    	}
    	
    	return theOutput;
    }
}
