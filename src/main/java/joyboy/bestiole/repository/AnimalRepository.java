package joyboy.bestiole.repository;

import joyboy.bestiole.entities.Animal;
import joyboy.bestiole.entities.Species;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal, Integer> {
  /*  List<Animal> findByName(String name);

    List<Animal> findByColor(String color);

    List<Animal> findBySex(String sex);

    List<Animal> findBySpeciesId(Integer speciesId);

   */
  List<Animal> findBySpecies(Species species);
  List<Animal> findByColorIn(List<String> colors);

    @Query("SELECT COUNT(a) FROM Animal a WHERE a.sex = :sex")
    long countBySex(@Param("sex") String sex);

    @Query("""
           SELECT CASE WHEN COUNT(p) > 0 THEN true ELSE false END
           FROM Person p JOIN p.animals a
           WHERE a = :animal
           """)
    boolean isOwned(@Param("animal") Animal animal);


}
