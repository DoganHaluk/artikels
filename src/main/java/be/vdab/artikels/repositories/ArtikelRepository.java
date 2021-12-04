package be.vdab.artikels.repositories;

import be.vdab.artikels.domain.Artikel;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface ArtikelRepository extends JpaRepository<Artikel, Long> {
    List<Artikel> findByPrijsBetween(BigDecimal van, BigDecimal tot);

    BigDecimal findHoogstePrijs();

    @EntityGraph (value="Artikel.metArtikelgroep")
    List<Artikel> findByArtikelgroepNaam(String naam);
}
