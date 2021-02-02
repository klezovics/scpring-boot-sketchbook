package com.klezovich.dependencyinjectiondemo.beans;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import javax.annotation.PostConstruct;

//@Configuration
@Slf4j
public class PrinterConfiguration {

    @Value("${app.msg}")
    private String msg;

    @Bean(initMethod = "init")
    @Primary
    FilesystemPrinter filesystemPrinter() {
        return new FilesystemPrinter();
    }

    @Bean
    Printer restApiPrinter() {
        return new RestApiPrinter();
    }

    @PostConstruct
    void printProperty() {
        log.error("::msg is "+msg);
    }
}
