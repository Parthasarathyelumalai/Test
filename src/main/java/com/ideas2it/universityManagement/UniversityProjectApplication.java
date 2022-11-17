package com.ideas2it.universityManagement;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Parthasarathy Elumalai
 * @version 1.0
 */
@SpringBootApplication
@Slf4j
public class UniversityProjectApplication {

    public static void main(String[] args) {

        SpringApplication.run(UniversityProjectApplication.class, args);
        log.info("Spring Boot Start..............");
    }

    /**
     * Generate password Encoder
     * @return PasswordEncoder - pass new instance of password encoder
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

}
