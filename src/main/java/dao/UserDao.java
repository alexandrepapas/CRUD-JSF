package dao;

import model.User;

import java.io.Serializable;
import java.util.List;

public interface UserDao extends Serializable {

    User save(User user);
    User findById(Long id);
    List<User> findAll();
    User update(User user);
    void deletebyId(Long id);
}
