package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> allUsers() {
        return entityManager.createQuery("from User", User.class)
                .getResultList();
    }
    @Override
    public void addUser(User user) {
        if(user.getId() == null) {
            entityManager.persist(user);
        } else entityManager.merge(user);
    }

    @Override
    public void deleteUser(Long id) {
        entityManager.remove(getById(id));
    }

    @Override
    public User editUser(User user) {
        return entityManager.merge(user);
    }

    @Override
    public User getById(Long id) {
        return entityManager.find(User.class, id);
    }
}
