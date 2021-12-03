package be.vdab.artikels.repositories;

import be.vdab.artikels.domain.Artikel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtikelRepository extends JpaRepository<Artikel, Long> {

}
