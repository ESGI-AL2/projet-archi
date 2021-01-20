package dao;

import java.util.ArrayList;
import java.util.List;

import model.User;

public class UserDao {
    private List<User> users = new ArrayList<>();
    private static UserDao instance;

    private UserDao() {
    }

    public static UserDao getInstance() {
        if (instance == null) {
            instance = new UserDao();
        }
        return instance;
    }

    public List<User> getUsers() {
        return users;
    }

    public User getUserById(int id) {
        for (User User : users) {
            if (User.getId() == id) {
                return User;
            }
        }
        return null;
    }
}




