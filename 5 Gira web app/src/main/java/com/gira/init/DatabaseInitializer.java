package com.gira.init;

import com.gira.service.ClassificationsService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitializer implements CommandLineRunner {
   private final ClassificationsService classificationsService;

    public DatabaseInitializer(ClassificationsService classificationsService) {
        this.classificationsService = classificationsService;
    }

    @Override
    public void run(String... args) throws Exception {
        classificationsService.init();
    }
}
