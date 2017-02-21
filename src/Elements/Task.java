package Elements;

public class Task extends Observable{
	
	private String content;
	private int priority;
	private boolean done;
	
	public Task(String content) {
		this.content = content;
		this.priority = 0;
		this.done = false;
	}
	
	public Task(String content, int priority) {
		this.content = content;
		this.priority = priority;
		this.done = false;
	}
	
	public String getContent() {
		return (this.content);
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public int getPriority() {
		return (this.priority);
	}
	
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	public boolean getDone() {
		return (this.done);
	}
	
	public void setDone(boolean done) {
		this.done = done;
	}
}
