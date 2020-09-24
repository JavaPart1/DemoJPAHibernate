package be.vdab;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ChangeVisitor {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("mysqlcontainer");
            em = emf.createEntityManager();
            EntityTransaction tx =em.getTransaction();
            tx.begin();
            Visitor visitor = em.find(Visitor.class, 1L);
            System.out.println(visitor.getId() + " " + visitor.getName());
            tx.commit();
            visitor.setName("jul");
            tx.begin();
            tx.commit();
//            em.detach(visitor);
//            em.clear();
//            em.close();
            visitor.setName("Rudi");
            System.out.println(visitor.getId() + " " + visitor.getName());
            tx.begin();
            tx.commit();
        } finally {
            if (em != null) em.close();
            if (emf != null) emf.close();
        }

    }
}
