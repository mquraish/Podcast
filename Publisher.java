public class Publisher {

	private String pubname;

	private String category;

	private String event;

	public Publisher(String Name, String Category, String Event) {
		//@Begin
		pubname = Name;
		category = Category;
		event = Event;
		//@End
	}

	public void publish(PubSubServer Server) {                                //Publisher Publishes the event
	//@Begin
	Server.send(pubname, category, event);
	//@End
	}

}
