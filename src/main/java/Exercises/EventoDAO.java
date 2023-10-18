package Exercises;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class EventoDAO {
    private final EntityManager em;

    public EventoDAO(EntityManager em) {
        this.em = em;
    }

    public void saveEvent (Evento ev) {
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.persist(ev);
            transaction.commit();
            System.out.println("event saved");
        } catch (Exception ex) {
            System.err.println("Exception" + ex.getMessage());
        }

    }

    public Evento getEventbyId (long id) {
        return em.find(Evento.class, id);
    }

    public void deleteEventwithId (long id) {
        try {
            Evento target = em.find(Evento.class, id);
            if (target != null) {
                EntityTransaction transaction = em.getTransaction();
                transaction.begin();
                em.remove(target);
                transaction.commit();
                System.out.println("event deleted");
            } else {
                System.out.println("no event found");
            }
        } catch (Exception ex) {
            System.err.println("Exception" + ex.getMessage());
        }
    }
}
