package com.example.auraly;

import com.example.auraly.service.DailyHoroscopeNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//@EntityScan("com.example.auraly.model.entity")
@EnableScheduling

public class AuralyApplication implements CommandLineRunner {

    @Autowired
    private    DailyHoroscopeNotificationService dailyHoroscopeNotificationService;

    public static void main(String[] args) {
        SpringApplication.run(AuralyApplication.class, args);
    }

    @Override
    public void run(String... args) {
        dailyHoroscopeNotificationService.sendDailyPushes();
    }
}
