package br.edu.unijuazeiro.videostore.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.edu.unijuazeiro.videostore.dao.util.ConnectionFactory;
import br.edu.unijuazeiro.videostore.model.DVD.DVD;

public class DVDDAO {

    public void save(DVD dvd) {
        EntityManager em = ConnectionFactory.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(dvd);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
    }

    public void update(DVD dvd) {
        EntityManager em = ConnectionFactory.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(dvd);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
    }

    public void remove(DVD dvd) {
        EntityManager em = ConnectionFactory.getEntityManager();
        try {
            em.getTransaction().begin();
            DVD d = em.find(DVD.class, dvd.getCode());
            em.remove(d);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
    }

    public DVD findById(Integer code) {
        EntityManager em = ConnectionFactory.getEntityManager();
        DVD d = em.find(DVD.class, code);
        if (em.isOpen()) {
            em.close();
        }
        return d;
    }

    public List<DVD> list() {
        EntityManager em = ConnectionFactory.getEntityManager();
        List<DVD> dvds = em.createQuery("from DVD", DVD.class).getResultList();
        if (em.isOpen()) {
            em.close();
        }
        return dvds;
    }

}
