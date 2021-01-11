package factories;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

import model.User;

public class UserFactory {

	private List<User> users = new ArrayList<User>();
	private static UserFactory instance ;
	
	private UserFactory () {			
	}
	
	public static UserFactory getInstance() {
		if (instance == null) {
			instance = new UserFactory() ;}
		return instance ;
	}

	public void addUser (JsonNode json) {
		int id = json.get("id").intValue();
		String firstName = json.get("firstName").textValue();
		String lastName = json.get("lastName").textValue();
		String email = json.get("email").textValue();
		User user = new User (id, firstName, lastName, email);
		users.add(user);
	}
	
	public List<User> getUsers () {
		return users;
	}
	
	public User getUserById (int id)
	{
		for (User user: users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}
	
}
