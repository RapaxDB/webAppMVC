package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    public void addUser(User user);
    public void deleteUser(int id);
    public User getUserById(int id);
    public void editUser (User user);
    public List<User> getUsers();
}
