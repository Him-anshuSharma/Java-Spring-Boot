package project.hibernate.jpa.helpers;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EmfProvider {
    private static EntityManagerFactory emf;

    private EmfProvider() {
    }

    public static synchronized EntityManagerFactory getEmf() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("taskPU");
        }
        return emf;
    }

    public static void close() {
        emf.close();
    }
}
