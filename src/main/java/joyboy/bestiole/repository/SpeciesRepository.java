package joyboy.bestiole.repository;

import joyboy.bestiole.entities.Species;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpeciesRepository extends JpaRepository<Species, Integer> {
    Species findFirstByCommonName(String commonName);
    List<Species> findByLatinNameContainingIgnoreCase(String text);


}
