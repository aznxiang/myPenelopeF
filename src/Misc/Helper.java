package Misc;

import java.util.Vector;

import Elements.Group;
import Elements.Project;
import Elements.Task;

public class Helper {
	public static int getGroupVectorIndex(Vector<Group> groups, String groupName) {
		int returnValue = 0;
		
		for (Group group : groups) {
			if (group.getName().equals(groupName)) {
				return (returnValue);
			}
			returnValue += 1;
		}
		return (-1);
	}
	
	public static int getProjectVectorIndex(Vector<Project> projects, String ProjectName) {
		int returnValue = 0;

		for (Project project : projects) {
			if (project.getName().equals(ProjectName)) {
				return (returnValue);
			}
			returnValue += 1;
		}
		return (-1);
	}
	
	public static int getTaskVectorIndex(Vector<Task> tasks, String ProjectName) {
		int returnValue = 0;

		for (Task task : tasks) {
			if (task.getContent().equals(ProjectName)) {
				return (returnValue);
			}
			returnValue += 1;
		}
		return (-1);
	}
}
