package factories;

import com.fasterxml.jackson.databind.JsonNode;

import dao.IUserDao;
import dao.memoryList.UserDaoMemoryList;
import domain.User;

public class UserFactory {


    private static UserFactory instance;

    private UserFactory() {
    }

    public static UserFactory getInstance() {
        if (instance == null) {
            instance = new UserFactory();
        }
        return instance;
    }

    public void addUser(JsonNode json) {
        int id = json.get("id").intValue();
        String firstName = json.get("firstName").textValue();
        String lastName = json.get("lastName").textValue();
        String email = json.get("email").textValue();
        User user = new User(id, firstName, lastName, email);
        IUserDao userDao = DaoFactory.getUserDao();
        userDao.getUsers().add(user);

    }


}
