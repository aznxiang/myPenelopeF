package Elements;

public class User extends Observable{
	private String name;
	
	public User(String name) {
		this.name = name;
	}
	
	public String getName() {
		return (this.name);
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
