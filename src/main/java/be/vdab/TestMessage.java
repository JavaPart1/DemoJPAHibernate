package be.vdab;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestMessage {
    private static EntityManagerFactory emf;

    private static void print(int pos, Message memMessage){
        EntityManager em = emf.createEntityManager();
        Message dbMessage = em.find(Message.class, memMessage.getId());
        em.close();
        System.out.println(pos + ": " + memMessage.getText() + "\t"
                + ((dbMessage != null) ? dbMessage.getText() : "null"));
    }

    public static void main(String[] args) {
        EntityManager em = null;
        try {
            emf = Persistence.createEntityManagerFactory("mysqlcontainer");
            em = emf.createEntityManager();

            EntityTransaction tx = em.getTransaction();
            tx.begin();
            Message m =em.find(Message.class, 100L);
            if (m != null){
                em.remove(m);
            }
            tx.commit();

            // Test begins
            tx.begin();
            m = new Message(100,"AAA");
            print(1, m);
            em.persist(m);
            tx.commit();
            print(2,m);
            m.setText("BBB");
        }
    }
}
