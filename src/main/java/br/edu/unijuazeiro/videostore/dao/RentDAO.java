package br.edu.unijuazeiro.videostore.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.edu.unijuazeiro.videostore.dao.util.ConnectionFactory;
import br.edu.unijuazeiro.videostore.model.rent.Rent;

public class RentDAO {

    public void save(Rent rent) {
        EntityManager em = ConnectionFactory.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(rent);
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

    public void update(Rent rent) {
        EntityManager em = ConnectionFactory.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(rent);
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

    public void remove(Rent rent) {
        EntityManager em = ConnectionFactory.getEntityManager();
        try {
            em.getTransaction().begin();
            Rent r = em.find(Rent.class, rent.getCode());
            em.remove(r);
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

    public Rent findById(Integer code) {
        EntityManager em = ConnectionFactory.getEntityManager();
        Rent r = em.find(Rent.class, code);
        if (em.isOpen()) {
            em.close();
        }
        return r;
    }

    public List<Rent> list() {
        EntityManager em = ConnectionFactory.getEntityManager();
        List<Rent> rents = em.createQuery("from Rent", Rent.class).getResultList();
        if (em.isOpen()) {
            em.close();
        }
        return rents;
    }
}
