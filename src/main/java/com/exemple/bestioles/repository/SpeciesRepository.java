// Fichier : src/main/java/com/exemple/bestioles/repository/SpeciesRepository.java

package com.exemple.bestioles.repository;

import joyboy.bestiole.entities.Species;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// JpaRepository prend en paramètres : <Type de l'Entité, Type de la Clé Primaire>
@Repository
public interface SpeciesRepository extends JpaRepository<Species, Long> {
    // Spring Data JPA génère automatiquement les implémentations de findAll, save, findById, delete, etc.
}