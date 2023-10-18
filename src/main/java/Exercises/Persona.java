package Exercises;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "person")
public class Persona {
    @Id
    @GeneratedValue
    private long id;
    @Column
    private String nome;
    @Column
    private String cognome;
    @Column
    private String email;
    @Column
    private LocalDate nascita;
    @Enumerated(EnumType.STRING)
    @Column
    private Sesso sesso;
    @ManyToMany
    @JoinTable (
        name = "persona_partecipazione",
                joinColumns = @JoinColumn(name = "persona_id"),
        inverseJoinColumns = @JoinColumn(name = "partecipazione_id")
    )
    private List<Partecipazione> partecipazioni = new ArrayList<>();

    public Persona() {}

    public Persona(String nome, String cognome, String email, LocalDate nascita, Sesso sesso) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.nascita = nascita;
        this.sesso = sesso;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getNascita() {
        return nascita;
    }

    public void setNascita(LocalDate nascita) {
        this.nascita = nascita;
    }

    public Sesso getSesso() {
        return sesso;
    }

    public void setSesso(Sesso sesso) {
        this.sesso = sesso;
    }

    public List<Partecipazione> getPartecipazioni() {
        return partecipazioni;
    }

    public void setPartecipazioni(List<Partecipazione> partecipazioni) {
        this.partecipazioni = partecipazioni;
    }
}
