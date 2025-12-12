package joyboy.bestiole.repository;

import joyboy.bestiole.entities.Species;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(path = "species", collectionResourceRel = "species-resource")
public interface SpeciesRepository extends JpaRepository<Species, Integer> {
    @RestResource(path = "by-cn")
    Species findFirstByCommonName(String commonName);

    List<Species> findByLatinNameContainingIgnoreCase(String text);
    @Query("SELECT s FROM Species s ORDER BY s.commonName ASC")
    List<Species> findAllOrderedByCommonNameAsc();
    @Query("SELECT s FROM Species s WHERE s.commonName LIKE :text")
    List<Species> searchByCommonNameLike(@Param("text") String text);




}
