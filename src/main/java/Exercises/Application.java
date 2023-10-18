package Exercises;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;


public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("E4_D13");

    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();

        EventoDAO ed = new EventoDAO(em);
        PersonaDAO pd = new PersonaDAO(em);
        PartecipazioneDAO pad = new PartecipazioneDAO(em);
        LocationDAO ld = new LocationDAO(em);

        Persona pe1 = new Persona("john","doe","john.doe@none.it",LocalDate.now(),Sesso.MALE);
        Location lo1 = new Location("milano","milano", new ArrayList<Evento>());
        Evento ev1 = new Evento("tomorrowland",LocalDate.now(),"hardcorefest",TipoEvento.PUBLIC,300,new HashSet<Partecipazione>(),lo1);
        Partecipazione pa1 = new Partecipazione(new ArrayList<Persona>(),ev1,Stato.DA_CONFERMARE);

        try {
            pd.savePerson(pe1);
            ld.saveLocation(lo1);
            ed.saveEvent(ev1);
            pad.saveParticipation(pa1);

        }catch (Exception ex) {
            System.err.println("Exception" + ex.getMessage());
        } finally {
            em.close();
            emf.close();
        }
    }
}
