package project.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

public class DBHelper {
    @PersistenceContext(unitName = "PERSISTENCE")
    private EntityManager em;
    private static DBHelper singlton = new DBHelper();

    private DBHelper() {
    }

    public static DBHelper getInstance() {
        return singlton;
    }

    public EntityManager getEm() {
        return em;
    }
}
