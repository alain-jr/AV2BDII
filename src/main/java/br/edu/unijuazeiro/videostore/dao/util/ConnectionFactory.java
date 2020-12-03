package br.edu.unijuazeiro.videostore.dao.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {
    private static EntityManagerFactory emf; // =Persistence.createEntityManagerFactory("unit-unijuazeiro");

    static {
        emf = Persistence.createEntityManagerFactory("unit-unijuazeiro");
    }

    private ConnectionFactory() {

    }

    public static EntityManagerFactory getEmf() {
        return emf;
    }

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public static void close() {
        emf.close();
    }

}
