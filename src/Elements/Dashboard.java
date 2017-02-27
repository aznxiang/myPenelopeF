package Elements;

import java.util.Vector;

public class Dashboard implements IObserver{
	
	private Vector<Message> messages;
	private static Dashboard instance;
	
	private Dashboard() {
	}
	
	public static Dashboard getInstance() {
		if (instance == null) {
			instance = new Dashboard();
			instance.messages = new Vector<Message>();
		}
		return (instance);
	}
	
	public void notifyChange(Message message) {
		messages.add(message);
	}
	
	public Vector<Message> getMessages() {
		return (messages);
	}
}
