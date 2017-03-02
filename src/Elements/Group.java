package Elements;

import java.util.Vector;

public class Group extends Observable {
	private String name;
	private Vector<User> users;
	
	public Group(String name, Vector<User> users, IObserver observer) {
		this.name = name;
		this.users = users;
		this.addObserver(observer);
	}
	
	public Group(String name, IObserver observer) {
		this.name = name;
		this.addObserver(observer);
		this.users = new Vector<User>();
	}
	
	public String getName() {
		return (this.name);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Vector<User> getUsers() {
		return (this.users);
	}
	
	public void setUsers(Vector<User> users) {
		this.users = users;
	}
	
	public void addUser(User user) {
		this.users.add(user);
	}
}
