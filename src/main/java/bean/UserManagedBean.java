package bean;

import dao.UserDao;
import jakarta.annotation.ManagedBean;
import model.User;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@SessionScoped
public class UserManagedBean implements Serializable {

    @Inject
    private UserDao userDao;

    private User user = new User();

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getUsers() {
        return userDao.findAll();
    }

    public String save() {
        userDao.save(user);
        user = new User();
        return "index?faces-redirect=true";
    }

    public String delete(User user) {
        userDao.deletebyId(user.getId());
        this.user = user;
        return "edit?faces-redirect=true";
    }

    public String edit(User user) {
        this.user = user;
        return "edit";
    }

    public String update() {
        userDao.update(user);
        user = new User();
        return "index?faces-redirect=true";
    }
}
