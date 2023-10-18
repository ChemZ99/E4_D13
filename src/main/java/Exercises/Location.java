package Exercises;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "location")
public class Location {
    @Id
    @GeneratedValue
    private long id;
    @Column
    private String nome;
    @Column
    private String citta;
    @OneToMany(mappedBy = "location")
    private List<Evento> eventi = new ArrayList<>();

    public Location() {}

    public Location(String nome, String citta, List<Evento> eventi) {
        this.nome = nome;
        this.citta = citta;
        this.eventi = eventi;
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

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public List<Evento> getEventi() {
        return eventi;
    }

    public void setEventi(List<Evento> eventi) {
        this.eventi = eventi;
    }
}
