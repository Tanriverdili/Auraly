package com.astro.app.auraly;

import jakarta.persistence.Entity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;

@SpringBootApplication
@EntityScan("com.astro.app.auraly.entity")
public class AuralyApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuralyApplication.class, args);
    }

}
