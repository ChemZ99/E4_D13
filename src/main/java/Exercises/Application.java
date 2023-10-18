package Exercises;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;


public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("E4_D12");

    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();

        Evento ev1 = new Evento("test1", LocalDate.now(),"this is a test",TipoEvento.PUBLIC,30);

        try {
            EventoDAO ed = new EventoDAO(em);
            ed.saveEvent(ev1);
            Evento readedEv = ed.getEventbyId(2);
            if (readedEv != null) {
                System.out.println(readedEv);
            }
            ed.deleteEventwithId(3);

            Evento evfromDB = ed.getEventbyId(6);
            if (evfromDB != null) {
                evfromDB.setDescrizione("elemento modificato pre refresh");
                System.out.println(evfromDB);
                em.refresh(evfromDB);
                System.out.println("post refresh");
                System.out.println(evfromDB);
            }
        }catch (Exception ex) {
            System.err.println("Exception" + ex.getMessage());
        } finally {
            em.close();
            emf.close();
        }
    }
}
