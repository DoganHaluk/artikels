package be.vdab.artikels.repositories;

import be.vdab.artikels.domain.Artikel;
import be.vdab.artikels.domain.Artikelgroep;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest(showSql = false)
@Sql({"/insertArtikelgroepen.sql", "/insertArtikels.sql"})
class ArtikelRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {
    private static final String ARTIKELS = "artikels";
    private final ArtikelRepository repository;

    ArtikelRepositoryTest(ArtikelRepository repository) {
        this.repository = repository;
    }

    @Test
    void findByPrijsBetween() {
        assertThat(repository.findByPrijsBetween(BigDecimal.ONE, BigDecimal.valueOf(100)))
                .hasSize(countRowsInTableWhere(ARTIKELS, "prijs between 1 and 100"))
                .allSatisfy(artikel -> assertThat(artikel.getPrijs()).isBetween(BigDecimal.ONE, BigDecimal.valueOf(100)));
    }

    @Test
    void findHoogstePrijs() {
        assertThat(repository.findHoogstePrijs())
                .isEqualByComparingTo(jdbcTemplate.queryForObject("select max(prijs) from artikels", BigDecimal.class));
    }

    @Test
    void findByArtikelgroepNaam() {
        var groep = "groep1";
        assertThat(repository.findByArtikelgroepNaam(groep))
                .hasSize(countRowsInTableWhere(ARTIKELS, "artikelgroepid= (select id from artikelgroepen where naam= 'groep1')"))
                .first()
                .extracting(Artikel::getArtikelgroep)
                .extracting(Artikelgroep::getNaam)
                .isEqualTo(groep);
    }
}
