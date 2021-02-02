package com.klezovich.dependencyinjectiondemo;

import com.klezovich.dependencyinjectiondemo.beans.ReportMaker;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@Slf4j
@SpringBootApplication
public class DependencyInjectionDemoApplication {

    //@Autowired
    //private ReportMaker reportMaker;

    @Autowired
    private ApplicationContext ctx;

    public static void main(String[] args) {
        SpringApplication.run(DependencyInjectionDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner getRunner() {

        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                log.info("Hello from runner !");
            }
        };
    }
}
