package joyboy.bestiole.repository;

import joyboy.bestiole.entities.Species;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeciesRepository extends JpaRepository<Species, Integer> {}
