package be.vdab.artikels.domain;

import javax.persistence.*;

@Entity
@Table(name = "artikelgroepen")
public class Artikelgroep {
    @Id
    private long id;
    private String naam;

    public long getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }
}
