package joyboy.bestiole.repository;

import joyboy.bestiole.entities.Species;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SpeciesRepository extends JpaRepository<Species, Integer> {
    Species findFirstByCommonName(String commonName);
    List<Species> findByLatinNameContainingIgnoreCase(String text);
    @Query("SELECT s FROM Species s ORDER BY s.commonName ASC")
    List<Species> findAllOrderedByCommonNameAsc();
    @Query("SELECT s FROM Species s WHERE s.commonName LIKE :text")
    List<Species> searchByCommonNameLike(@Param("text") String text);




}
