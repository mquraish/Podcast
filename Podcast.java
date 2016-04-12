//@Begin
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
//@End
public class Podcast {

	public static void main(String[] args) /*@Begin*/throws IOException /*@End*/ {
		//@Begin
String csvFile = args[0]; //takes filename from command line
		String line = "";
		PubSubServer Server = new PubSubServer();
	

		BufferedReader br = new BufferedReader(new FileReader(csvFile)); 
		
			while ((line = br.readLine()) != null) 
			{
				String[] text = line.split(",");
				for(int i=0; i<text.length; i++)
					text[i]=text[i].toLowerCase(); //handles upper-case/lower-case names
			
			
				if (text[0].contains("subscribe"))
				{
					Subscriber sub = new Subscriber(text[1], text[2]);
					sub.subscribe(Server);                             // Subscribers register in the server
				}
	
		
				if (text[0].contains("publish"))
				{
					Publisher pub = new Publisher(text[1], text[2], text[3]);
					pub.publish(Server);                               // Publishers publish in the server
				}
				
				if (text[0].contains("unsubscribe"))
				{
					Subscriber sub = new Subscriber(text[1], text[2]);
					sub.unsubscribe(Server);
				}
			
			}	
			Server.clear(); //clear data before exit
	//@End
	}

}
