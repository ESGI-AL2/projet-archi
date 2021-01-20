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
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public List <Integer> getAllId () {
        List <Integer> result = new ArrayList <>();
        for (User user : users) {
            result.add(user.getId());
        }
        return result;
    }
}




