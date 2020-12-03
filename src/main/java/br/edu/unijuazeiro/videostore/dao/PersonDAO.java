package br.edu.unijuazeiro.videostore.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import br.edu.unijuazeiro.videostore.dao.util.ConnectionFactory;
import br.edu.unijuazeiro.videostore.model.person.Person;

public class PersonDAO {

    public void save(Person person) {
        EntityManager em = ConnectionFactory.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(person);
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

    public void update(Person person) {
        EntityManager em = ConnectionFactory.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(person);
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

    public void remove(Person person) {
        EntityManager em = ConnectionFactory.getEntityManager();
        try {
            em.getTransaction().begin();
            Person p = em.find(Person.class, person.getCode());
            em.remove(p);
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

    public Person findById(Integer code) {
        EntityManager em = ConnectionFactory.getEntityManager();
        Person p = em.find(Person.class, code);
        if (em.isOpen()) {
            em.close();
        }
        return p;
    }

    public Person findByEmail(String email) {
        EntityManager em = ConnectionFactory.getEntityManager();
        Person p = null;
        try {
            p = em.createQuery("from Person p where p.email = :mail", Person.class).setParameter("mail", email)
                    .getSingleResult();
        } catch (NoResultException e) {
            // System.out.println("Não foi encontrado cliente com esse e-mail.");
            return null;
        }
        if (em.isOpen()) {
            em.close();
        }
        return p;
    }

    public List<Person> findByName(String name) {
        EntityManager em = ConnectionFactory.getEntityManager();
        List<Person> persons = em.createQuery("select p from Person p where lower(c.name) like lower(:name)", Person.class)
                .setParameter("name", "%" + name + "%").getResultList();
        if (em.isOpen()) {
            em.close();
        }
        return persons;
    }

    public List<Person> findByAddress(String street) {
        EntityManager em = ConnectionFactory.getEntityManager();
        List<Person> persons = em.createQuery("select p from Person p join p.address a where lower(a.street) like lower(:street)", Person.class)
                .setParameter("street", "%" + street + "%").getResultList();
        if (em.isOpen()) {
            em.close();
        }
        return persons;
    }

    public List<Person> findByNameOrAddress(String text) {
        EntityManager em = ConnectionFactory.getEntityManager();
        List<Person> persons = em.createQuery("select p from Person p join p.address a "+
           "where lower(p.name) like lower(:search) or lower(a.street) like lower(:search)", Person.class)
                .setParameter("search", "%" + text + "%").getResultList();
        if (em.isOpen()) {
            em.close();
        }
        return persons;
    }


    public List<Person> list() {
        EntityManager em = ConnectionFactory.getEntityManager();
        List<Person> persons = em.createQuery("from Person", Person.class).getResultList();
        if (em.isOpen()) {
            em.close();
        }
        return persons;
    }
}
