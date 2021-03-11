package web.dao;

import web.model.User;
import java.util.List;

public interface UserDAO {
    public List<User> allUsers();
    public void addUser(User user);
    public void deleteUser(Long id);
    public User editUser(User user);
    public User getById(Long id);
}
