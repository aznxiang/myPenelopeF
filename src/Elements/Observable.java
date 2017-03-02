package Elements;

import java.util.Vector;

public class Observable {
	
	private Vector<IObserver> observers;
	private Vector<Message> messages;
	
	public Observable() {
		this.observers = new Vector<IObserver>();
		this.messages = new Vector<Message>();
	}
	
	public void addObserver(IObserver observer) {
		this.observers.add(observer);
	}
	
	public void removeObserver(IObserver observer) {
		this.observers.remove(observer);
	}
	
	public void notifyObserver(Message message) {
		System.out.println("message =" + message.getMessage());
		for (IObserver observer : observers) {
			System.out.println("through devices");
			observer.notifyChange(message);
		}
	}
	
	public void addMessage(Message message) {
		this.messages.add(message);
	}
	
	public Vector<IObserver> getObservers() {
		return (this.observers);
	}
	
	public void setObservers(Vector<IObserver> observers) {
		this.observers = observers;
	}
	
	public Vector<Message> getMessages() {
		return (this.messages);
	}
	
	public void setMessages(Vector<Message> messages) {
		this.messages = messages;
	}
}

