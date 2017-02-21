package Elements;

import java.util.Vector;

public class Group extends Observable {
	private String name;
	private Vector<User> users;
	
	public Group(String name, Vector<User> users) {
		this.name = name;
		this.users = users;
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
}
