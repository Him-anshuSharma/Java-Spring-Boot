package project.hibernate.jpa.dao;

import project.hibernate.jpa.entities.User;
import project.hibernate.jpa.helpers.DbHelpers;

public class UserDao {

    public void insertUser(User user) {
        DbHelpers.runTransaction(em -> em.persist(user));
    }

    public void updateUser(User user) {
        DbHelpers.runTransaction(em -> em.merge(user));
    }

    public User getUser(int id) {
        return DbHelpers.runQuery((em) -> {
            User usr = em.find(User.class, id);
            usr.getTasks().size();
            return usr;
        });
    }

    public User getUserWithTasks(int id) {
        return DbHelpers.runQuery((em) -> {
            return em.createQuery("Select u from User u join fetch u.tasks where u.id = :id", User.class)
                    .setParameter("id", id).getSingleResult();

        });
    }

    public void deleteUser(int id) {
        DbHelpers.runTransaction(em -> {
            User usr = em.find(User.class, id);
            if (usr != null)
                em.remove(usr);
        });
    }

}