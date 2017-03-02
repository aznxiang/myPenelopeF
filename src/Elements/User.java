package Elements;

import org.json.*;

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

    public static Vector<Task> getAll(String path) {
	File jsonFile = new File(path);
	FileInputStream fis = new FileInputStream(jsonFile);
	byte[] data = new byte[(int) jsonFile.length()];
	fis.read(data);
	fis.close();
	String filecontent = new String(data, "UTF-8");
	Vector<User> users = new Vector<User>();
	JSONArray arr = new JSONArray(filecontent);
	for (int i = 0; i < arr.length(); i++)
	    {
		JSONObject obj = arr.getJSONObject(i);
		String name = obj.getString("name");
		User user = new User(name);
	    }
	return (users);
    }
}
