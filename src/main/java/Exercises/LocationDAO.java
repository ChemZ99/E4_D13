package Exercises;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class LocationDAO {
    private final EntityManager em;

    public LocationDAO(EntityManager em) {
        this.em = em;
    }

    public void saveLocation (Location lo) {
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.persist(lo);
            transaction.commit();
            System.out.println("location saved");
        } catch (Exception ex) {
            System.err.println("Exception" + ex.getMessage());
        }

    }

    public Location getLocationbyId (long id) {
        return em.find(Location.class, id);
    }

    public void deleteLocationwithId (long id) {
        try {
            Location target = em.find(Location.class, id);
            if (target != null) {
                EntityTransaction transaction = em.getTransaction();
                transaction.begin();
                em.remove(target);
                transaction.commit();
                System.out.println("location deleted");
            } else {
                System.out.println("no location found");
            }
        } catch (Exception ex) {
            System.err.println("Exception" + ex.getMessage());
        }
    }
}
