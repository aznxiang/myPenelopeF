package Elements;

import java.util.Vector;

public class Project extends Observable {
	
	private String name;
	private String path;
	private Vector<Group> groups;
	private Vector<Task> tasks;
	
	public Project(String name, IObserver observer) {
		this.name = name;
		this.tasks = new Vector<Task>();
		this.groups = new Vector<Group>();
		this.addObserver(observer);
	}
	
	public Project(String name, Vector<Task> tasks, Vector<Group> groups, IObserver observer) {
		this.name = name;
		this.tasks = tasks;
		this.groups = groups;
		this.addObserver(observer);
	}
	
	public Project(String name, String path, Vector<Group> groups, IObserver observer) {
		this.name = name;
		this.path = path;
		this.groups = groups;
		this.tasks = new Vector<Task>();
		this.addObserver(observer);
	}
	
	public String getName() {
		return (this.name);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPath() {
		return (this.path);
	}
	
	public void setPath(String path) {
		this.path = path;
	}
	
	public Vector<Group> getGroups() {
		return (this.groups);
	}
	
	public void setGroups(Vector<Group> groups) {
		this.groups = groups;
	}
	
	public Vector<Task> getTasks() {
		return (this.tasks);
	}
	
	public void setTasks(Vector<Task> tasks) {
		this.tasks = tasks;
	}

	public void addTask(Task task) {
		this.tasks.add(task);
	}
	
	//TODO
	//method pour remplir les documents en fonction du path.
	//method pour checker toutes les 30 secondes si il y'a eu des modifications (suppression, ajout de fichier) dans le dossier du projet en question.
}
