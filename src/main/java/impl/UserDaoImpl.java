package impl;

import dao.UserDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import model.User;

import java.util.List;

public class UserDaoImpl implements UserDao {

    @PersistenceContext

    private EntityManager entityManager;

    @Override
    public User findById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public User save(User user) {
        entityManager.persist(user);
        return user;
    }
    @Override
    public List<User> findAll() {
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    @Override
    public User update(User user) {
        return entityManager.merge(user);
    }

    @Override

    public void deletebyId(Long id){
        User user = findById(id);
        if(user != null){
            entityManager.remove(user);
        }
    }

}
