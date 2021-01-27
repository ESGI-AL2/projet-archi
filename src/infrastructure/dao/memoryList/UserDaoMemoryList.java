package infrastructure.dao.memoryList;

import java.util.ArrayList;
import java.util.List;

import infrastructure.dao.IUserDao;
import domain.User;

public class UserDaoMemoryList implements IUserDao {
    private List<User> users = new ArrayList<>();
    private static UserDaoMemoryList instance;

    private UserDaoMemoryList() {
    }

    public static UserDaoMemoryList getInstance() {
        if (instance == null) {
            instance = new UserDaoMemoryList();
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




