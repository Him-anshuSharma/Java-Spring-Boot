package project.hibernate.jpa.helpers;

import java.util.function.Consumer;
import java.util.function.Function;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

public class DbHelpers {
    private static EntityManagerFactory emf = EmfProvider.getEmf();

    // For void operations
    static public void runTransaction(Consumer<EntityManager> operation) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            operation.accept(em); // execute lambda
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive())
                tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    // For operations that return a value
    static public <T> T runQuery(Function<EntityManager, T> query) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        T result = null;
        try {
            tx.begin();
            result = query.apply(em); // execute lambda
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive())
                tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
        return result;
    }
}
