package Elements;

public class Document extends Observable {
	private String name;
	
	public Document(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
