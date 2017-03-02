package Elements;

import java.io.File;
import java.io.FileInputStream;
import java.util.Vector;
import org.json.*;

public class Task extends Observable{
	
    private String name;
    private String content;
    private String projectName;
    private int priority;
    private boolean done;
	
    public Task(String name, String content, String projectName) {
	this.name = name;
	this.content = content;
	this.projectName = projectName;
	this.priority = 0;
	this.done = false;
    }
	
    public Task(String name, String content, int priority) {
	this.name = name;
	this.content = content;
	this.priority = priority;
	this.done = false;
    }
	
    public String getName() {
	return (this.name);
    }
	
    public void setName(String name) {
	this.name = name;
    }
	
    public String getContent() {
	return (this.content);
    }
	
    public void setContent(String content) {
	this.content = content;
    }
	
    public String getProjectName() {
	return (this.projectName);
    }
	
    public void setProjectName(String projectName) {
	this.projectName = projectName;
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
	
    public static Vector<Task> getAll(String path) {
	File jsonFile = new File(path);
	FileInputStream fis = new FileInputStream(jsonFile);
	byte[] data = new byte[(int) jsonFile.length()];
	fis.read(data);
	fis.close();
	String filecontent = new String(data, "UTF-8");
	Vector<Task> tasks = new Vector<Task>();
	JSONArray arr = new JSONArray(filecontent);
	for (int i = 0; i < arr.length(); i++)
	    {
		JSONObject obj = arr.getJSONObject(i);
		String projectName = obj.getString("projectName");
		String content = obj.getString("content");
		int priority = obj.getString("priority");
		boolean done = (1 == obj.getInt("done"));
		Task task = new Task(projectName, content, priority);
		task.setDone(done);
		tasks.addElement(task);
	    }
	return (tasks);
    }
}
