package infrastructure.dao;

import domain.User;

import java.util.List;

public interface IUserDao {
    public List<User> getUsers();
    public User getUserById(int id);
    public List <Integer> getAllId ();
}
