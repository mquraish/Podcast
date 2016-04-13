public class Subscriber {

	private String subname;

	private String category;

	public Subscriber(String Name, String Category) {
	//@Begin
	subname = Name;
	category = Category;
	//@End
	}

	public void subscribe(PubSubServer Server) {
	//@Begin
	Server.addSubscriber(subname, category);
	//@End
	}

	public void unsubscribe(PubSubServer Server) {
	//@Begin
	Server.removeSubscriber(subname, category);
	//@End
	}
	
// notify function displays the notification of events received by the subscribers
	public static void notify(String SubName, String Event, String PubName) {
	//@Begin
	System.out.println(""+SubName+" notified of "+Event+" from "+PubName);
	//@End
	}

}
