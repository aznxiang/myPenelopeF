package Elements;

import java.util.Vector;

public class Dashboard implements IObserver{
	
	private Vector<Message> messages;
	
	private Dashboard() {
	}
	
	private static Dashboard dashboard = new Dashboard();
	
	public static Dashboard getInstance() {
		return dashboard;
	}
	
	public void notifyChange(Message message) {
		messages.add(message);
		//TODO
		//updateView();
	}
}
