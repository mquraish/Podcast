//@Begin
import java.util.HashMap;
import java.util.LinkedList;
//@End

public class PubSubServer {
//@Begin
private HashMap<String, LinkedList<String>> hmap = new HashMap<String, LinkedList<String>>();
//@End

	public void addSubscriber(String Name, String Category) {
	//@Begin
	if(hmap.containsKey(Category)) // If category is already listed, just append user name
		
			{
				if 	(!hmap.get(Category).contains(Name))
				{
					hmap.get(Category).addLast(Name);
				}
		
			}
		
	else         //If category is not listed, create a new category and add user
			{
			LinkedList<String> sub = new LinkedList<String>();
				sub.addLast(Name);
				hmap.put(Category, sub);		
			}
	//@End
	
	}

	public void removeSubscriber(String Name, String Category) {
	//@Begin
	if(hmap.containsKey(Category))
			{
		hmap.get(Category).remove(Name);
			}
	//@End
	
	}

	public void send(String PubName, String Category, String Event) {
	//@Begin
	while(hmap.containsKey(Category))
           {
        	   for(int i=0; i<hmap.get(Category).size(); i++)
        	   {
        	    Subscriber.notify(hmap.get(Category).get(i), Event, PubName);
        	   }
        	
        	   break;   
        }
	//@End
	}

	public void clear() {
	//@Begin
	hmap.clear();
	//@End
	}

}
