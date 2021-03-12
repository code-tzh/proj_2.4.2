package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Role;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//@Repository
//public interface UserDaoImpl extends JpaRepository<Role, Long> {
//}

@Repository
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> allUsers() {
        return entityManager.createQuery("from User", User.class)
                .getResultList();
    }
    @Override
    public void addUser(User user) { entityManager.persist(user); }

    @Override
    public void deleteUser(Long id) {
        entityManager.createQuery("delete from User u where u.id = :id")
                .setParameter("id", id).executeUpdate();
    }

    @Override
    public User editUser(User user) {
        return entityManager.merge(user);
    }

    @Override
    public User getById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public User getUserByName(String username) {
        return (User) entityManager.createQuery("from User user where user.username = :username")
                .setParameter("username", username).getSingleResult();
    }

    @Override
    public Set<Role> getAllRoles() {
        Set<Role> roleSet = new HashSet<>();
        List<Role> roleList = entityManager.createQuery("select role from Role role").getResultList();
        roleSet.addAll(roleList);
        return roleSet;
    }
}

//    @Query List<User> users = entityManager.createQuery("SELECT DISTINCT a FROM User a JOIN FETCH a.roles b",
//            User.class).getResultList(); !!