package Exercises;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PersonaDAO {
    private final EntityManager em;

    public PersonaDAO(EntityManager em) {
        this.em = em;
    }

    public void savePerson (Persona pe) {
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.persist(pe);
            transaction.commit();
            System.out.println("person saved");
        } catch (Exception ex) {
            System.err.println("Exception" + ex.getMessage());
        }

    }

    public Persona getPersonbyId (long id) {
        return em.find(Persona.class, id);
    }

    public void deletePersonwithId (long id) {
        try {
            Persona target = em.find(Persona.class, id);
            if (target != null) {
                EntityTransaction transaction = em.getTransaction();
                transaction.begin();
                em.remove(target);
                transaction.commit();
                System.out.println("person deleted");
            } else {
                System.out.println("no person found");
            }
        } catch (Exception ex) {
            System.err.println("Exception" + ex.getMessage());
        }
    }
}
