package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    void addNewUser(User user);

    public User findById(int id);

    public void updateUser(int id, User user);
//    public void updateUser(User user);

    public void deleteUser(int id);

}
