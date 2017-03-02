package Elements;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;
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

    public static Vector<User> getAll(String path) {
		File jsonFile = new File(path);
		FileInputStream fis;
		try {
			fis = new FileInputStream(jsonFile);
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
		} catch (IOException e) {
			return (new Vector<User>());
		}
    }

    public static void storeAll(Vector<User> users, String path) {
		JSONArray arr = new JSONArray();

		for (int i = 0; i < users.size(); i++)
	    {
			JSONObject obj = new JSONObject();
			obj.put("name", users.elementAt(i).name);
			arr.put(obj);
		}
		try (FileWriter file = new FileWriter(path)) {
			file.write(arr.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
