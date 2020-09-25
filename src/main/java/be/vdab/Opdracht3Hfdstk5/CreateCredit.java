package be.vdab.Opdracht3Hfdstk5;

import be.vdab.Visitor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CreateCredit {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("mysqlcontainer");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            Credit credit = new Credit(10000.00);
            em.persist(credit);
            tx.commit();
            System.out.println("Creditlign created");
        } finally {
            if (em != null) em.close();
            if (emf != null) emf.close();
        }

    }

}
