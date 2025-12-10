package joyboy.bestiole.boot;

import joyboy.bestiole.entities.Animal;
import joyboy.bestiole.entities.Person;
import joyboy.bestiole.entities.Role;
import joyboy.bestiole.entities.Species;
import joyboy.bestiole.repository.AnimalRepository;
import joyboy.bestiole.repository.RoleRepository;
import joyboy.bestiole.repository.SpeciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import joyboy.bestiole.repository.PersonRepository;

import java.util.Arrays;
import java.util.List;

@Component
public class StartUp implements CommandLineRunner {


    @Autowired
    private SpeciesRepository speciesRepo;

    @Autowired
    private AnimalRepository animalRepo;

    @Autowired
    private PersonRepository personRepo;

    @Autowired
    private RoleRepository roleRepo;


    @Override
    public void run(String... args) throws Exception {
        System.out.println("\n========================");
        System.out.println("===    SELECT ALL    ===");
        System.out.println("========================");

        System.out.println("\n--- Species ---");
        speciesRepo.findAll().forEach(System.out::println);

        System.out.println("\n--- Animals ---");
        animalRepo.findAll().forEach(System.out::println);

        System.out.println("\n--- Persons ---");
        personRepo.findAll().forEach(System.out::println);

        System.out.println("\n--- Roles ---");
        roleRepo.findAll().forEach(System.out::println);



        System.out.println("\n========================");
        System.out.println("===      CREATE      ===");
        System.out.println("========================");

        Species sp = new Species();
        sp.setCommonName("Dragon");
        sp.setLatinName("Draconis");
        speciesRepo.save(sp);
        System.out.println("Created Species: " + sp);

        Role r = new Role();
        r.setLabel("Dresseur");
        roleRepo.save(r);
        System.out.println("Created Role: " + r);

        Person p = new Person();
        p.setFirstname("Jean");
        p.setLastname("Dupond");
        p.setAge(30);
        p.setLogin("jdupond");
        p.setMdp("1234");
        p.setActive(true);
        personRepo.save(p);
        System.out.println("Created Person: " + p);

        Animal a = new Animal();
        a.setName("Draco");
        a.setColor("Blue");
        a.setSex("M");
        a.setSpecies(sp);
        animalRepo.save(a);
        System.out.println("Created Animal: " + a);



        System.out.println("\n========================");
        System.out.println("===      UPDATE      ===");
        System.out.println("========================");

        sp.setCommonName("Grand Dragon");
        speciesRepo.save(sp);
        System.out.println("Updated Species: " + sp);

        r.setLabel("Super Dresseur");
        roleRepo.save(r);
        System.out.println("Updated Role: " + r);

        p.setAge(31);
        personRepo.save(p);
        System.out.println("Updated Person: " + p);

        a.setColor("Green");
        animalRepo.save(a);
        System.out.println("Updated Animal: " + a);



        System.out.println("\n========================");
        System.out.println("===      DELETE      ===");
        System.out.println("========================");

        animalRepo.deleteById(a.getId());
        System.out.println("Deleted Animal id=" + a.getId());

        personRepo.deleteById(p.getId());
        System.out.println("Deleted Person id=" + p.getId());

        roleRepo.deleteById(r.getId());
        System.out.println("Deleted Role id=" + r.getId());

        speciesRepo.deleteById(sp.getId());
        System.out.println("Deleted Species id=" + sp.getId());



        System.out.println("\n========================");
        System.out.println("===   FINAL SELECT   ===");
        System.out.println("========================");

        System.out.println("\n--- Species ---");
        speciesRepo.findAll().forEach(System.out::println);

        System.out.println("\n--- Animals ---");
        animalRepo.findAll().forEach(System.out::println);

        System.out.println("\n--- Persons ---");
        personRepo.findAll().forEach(System.out::println);

        System.out.println("\n--- Roles ---");
        roleRepo.findAll().forEach(System.out::println);



        System.out.println("\n========================");
        System.out.println("===   TP TERMINÉ !   ===");
        System.out.println("========================\n");


        System.out.println("\n========================");
        System.out.println("===   DEBUT TP04  ===");
        System.out.println("========================\n");


        System.out.println("=== TEST SPECIES ===");

        System.out.println("findFirstByCommonName('Dragon') : ");
        System.out.println(speciesRepo.findFirstByCommonName("Dragon"));

        System.out.println("findByLatinNameContainingIgnoreCase('dra') : ");
        speciesRepo.findByLatinNameContainingIgnoreCase("dra")
                .forEach(System.out::println);

        System.out.println("=== TEST PERSON ===");

        System.out.println("findByLastnameOrFirstname('Dupond', 'Jean') : ");
        personRepo.findByLastnameOrFirstname("Dupond", "Jean")
                .forEach(System.out::println);

        System.out.println("findByAgeGreaterThanEqual(30) : ");
        personRepo.findByAgeGreaterThanEqual(30)
                .forEach(System.out::println);


        System.out.println("=== TEST ANIMAL ===");

        Species spDragon = speciesRepo.findFirstByCommonName("Dragon");

        System.out.println("findBySpecies(spDragon) : ");
        animalRepo.findBySpecies(spDragon)
                .forEach(System.out::println);

        System.out.println("findByColorIn([\"Blue\", \"Green\"]) : ");
        animalRepo.findByColorIn(Arrays.asList("Blue", "Green"))
                .forEach(System.out::println);


        System.out.println("\n========================");
        System.out.println("===   TP04 TERMINÉ !   ===");
        System.out.println("========================\n");




    }

}
