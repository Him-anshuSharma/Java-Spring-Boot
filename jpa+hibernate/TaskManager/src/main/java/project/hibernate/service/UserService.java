package project.hibernate.service;

import project.hibernate.jpa.dao.UserDao;
import project.hibernate.jpa.entities.User;

public class UserService {
    private UserDao userDao;

    public UserService() {
        userDao = new UserDao();
    }

    public void addUser(User user) {
        if (user != null) {
            userDao.insertUser(user);
        }
    }

    public User getUser(int id) {
        User user = null;
        if (id != -1) {
            user = userDao.getUser(id);
        }
        return user;
    }

    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }

}
