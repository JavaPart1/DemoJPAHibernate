package be.vdab;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveMsg {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("mysqlcontainer");
            em = emf.createEntityManager();
            EntityTransaction tx =em.getTransaction();
            tx.begin();
            Message msg = new Message(3,"Bye Nate");
            em.persist(msg);
            tx.commit();
            System.out.println("msg saved");
        } finally {
            if (em != null) em.close();
            if (emf != null) emf.close();
        }
    }
}
