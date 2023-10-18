package Exercises;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "participation")
public class Partecipazione {
    @Id
    @GeneratedValue
    private long id;
    @ManyToMany(mappedBy = "partecipazioni")
    private List<Persona> persone = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Evento evento;
    @Enumerated
    @Column
    private Stato stato;
    public Partecipazione(){}

    public Partecipazione(List<Persona> persone, Evento evento, Stato stato) {
        this.persone = persone;
        this.evento = evento;
        this.stato = stato;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Persona> getPersone() {
        return persone;
    }

    public void setPersone(List<Persona> persone) {
        this.persone = persone;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Stato getStato() {
        return stato;
    }

    public void setStato(Stato stato) {
        this.stato = stato;
    }
}
