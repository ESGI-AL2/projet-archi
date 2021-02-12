package domain.dao;

import domain.model.User;

import java.util.List;

public interface UserDao {
    public List<User> getUsers();
    public User getUserById(int id);
    public List <Integer> getAllId ();
}
