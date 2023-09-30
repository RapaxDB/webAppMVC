package web.dao;


import web.model.User;

import java.util.List;

public interface UserDao {
    public void addUser(User user);
    public void deleteUser(int id);
    public User getUserById(int id);
    public List<User> getUsers();
    public void updateUser(User user);
}
