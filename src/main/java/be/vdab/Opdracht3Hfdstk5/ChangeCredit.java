package be.vdab.Opdracht3Hfdstk5;

import be.vdab.Visitor;

import javax.persistence.*;

public class ChangeCredit {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("mysqlcontainer");
            em = emf.createEntityManager();
            EntityTransaction tx =em.getTransaction();
            tx.begin();
            Credit credit = em.find(Credit.class,3L);
            em.lock(credit, LockModeType.OPTIMISTIC);
            // Change amount
            do {
                credit.setBalance(credit.getBalance() - 6000.00);
            } while (credit.getBalance() < 0);
            tx.commit();
        } finally {
            if (em != null) em.close();
            if (emf != null) emf.close();
        }

    }

}
