package Exercises;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PartecipazioneDAO {
    private final EntityManager em;

    public PartecipazioneDAO(EntityManager em) {
        this.em = em;
    }

    public void saveParticipation (Partecipazione pa) {
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.persist(pa);
            transaction.commit();
            System.out.println("participation saved");
        } catch (Exception ex) {
            System.err.println("Exception" + ex.getMessage());
        }

    }

    public Partecipazione getParticipationbyId (long id) {
        return em.find(Partecipazione.class, id);
    }

    public void deleteParticipationwithId (long id) {
        try {
            Partecipazione target = em.find(Partecipazione.class, id);
            if (target != null) {
                EntityTransaction transaction = em.getTransaction();
                transaction.begin();
                em.remove(target);
                transaction.commit();
                System.out.println("participation deleted");
            } else {
                System.out.println("no participation found");
            }
        } catch (Exception ex) {
            System.err.println("Exception" + ex.getMessage());
        }
    }
}
