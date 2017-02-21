package Elements;

import java.util.Vector;

public class Project extends Observable {
	
	private String name;
	private String path;
	private Vector<Group> groups;
	private Vector<Document> documents;
	
	public Project(String name, String path, Vector<Group> groups) {
		this.name = name;
		this.path = path;
		this.groups = groups;
		this.documents = new Vector<Document>();
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
	
	public Vector<Document> getDocuments() {
		return (this.documents);
	}
	
	public void setDocuments(Vector<Document> documents) {
		this.documents = documents;
	}
	
	//TODO
	//method pour remplir les documents en fonction du path.
	//method pour checker toutes les 30 secondes si il y'a eu des modifications (suppression, ajout de fichier) dans le dossier du projet en question.
}
