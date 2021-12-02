package be.vdab.artikels.domain;

import javax.persistence.*;

@Entity
@Table(name = "artikelgroepen")
public class Artikelgroep {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String naam;

    public Artikelgroep(long id, String naam) {
        this.id = id;
        this.naam = naam;
    }

    protected Artikelgroep() {
    }

    public long getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }
}
