package Misc;

import java.util.Vector;

import Elements.Group;
import Elements.Project;

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
}
