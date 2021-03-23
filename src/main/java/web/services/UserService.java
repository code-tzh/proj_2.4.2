package web.services;

import web.model.Role;
import web.model.User;

import java.util.List;
import java.util.Set;

public interface UserService {
    List<User> allUsers();
    void addUser(User user);
    void deleteUser(Long id);
    User editUser(User user);
    User getById(Long id);
    User getUserByName(String username);
}