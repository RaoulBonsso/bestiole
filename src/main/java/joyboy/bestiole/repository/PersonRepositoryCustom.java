package joyboy.bestiole.repository;

public interface PersonRepositoryCustom {

    void deletePersonsWithoutAnimals();

    void generateRandomPersons(int count);
}
