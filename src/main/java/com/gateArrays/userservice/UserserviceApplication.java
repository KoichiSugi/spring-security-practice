package com.gateArrays.userservice;

import com.gateArrays.userservice.domain.Role;
import com.gateArrays.userservice.domain.User;
import com.gateArrays.userservice.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class UserserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserserviceApplication.class, args);
    }


    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();//returns password
    }

    @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
            userService.saveRole(new Role(null, "ROLE_SLAVE"));
            userService.saveRole(new Role(null, "ROLE_USER"));
            userService.saveRole(new Role(null, "ROLE_MANAGER"));
            userService.saveRole(new Role(null, "ROLE_ADMIN"));
            userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

            userService.saveUser(new User(null, "John Nguyen", "john", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "Katsu Usui", "katsu", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "Min Che", "min", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "Hiromi Go", "hiromi", "1234", new ArrayList<>()));

            userService.addRoleToUser("john", "ROLE_USER");
            userService.addRoleToUser("john", "ROLE_MANAGER");
            userService.addRoleToUser("katsu", "ROLE_SLAVE");
            userService.addRoleToUser("min", "ROLE_MANAGER");
            userService.addRoleToUser("hiromi", "ROLE_USER");
            userService.addRoleToUser("hiromi", "ROLE_ADMIN");
            userService.addRoleToUser("hiromi", "ROLE_SUPER_ADMIN");
        };
    }

}
