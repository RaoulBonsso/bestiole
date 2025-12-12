package joyboy.bestiole.config;

import joyboy.bestiole.entities.Person;
import joyboy.bestiole.entities.Role;
import joyboy.bestiole.repository.PersonRepository;
import joyboy.bestiole.repository.RoleRepository;
import joyboy.bestiole.services.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@Configuration
public class SecurityConfig {

    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    public SecurityConfig(CustomUserDetailsService customUserDetailsService) {
        this.customUserDetailsService = customUserDetailsService;
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    CommandLineRunner initDatabase(PersonRepository userRepository, RoleRepository roleRepository, PasswordEncoder encoder) {
        return args -> {
            Role userRole = new Role();
            userRole.setLabel("ROLE_USER");
            roleRepository.save(userRole);

            Person user = new Person();
            user.setLastname(" SYLLA");
            user.setFirstname("Séga");
            user.setLogin("ssy");
            user.setMdp(encoder.encode("SYLLA"));
            user.setActive(true);
            userRepository.save(user);
        };
    }
}