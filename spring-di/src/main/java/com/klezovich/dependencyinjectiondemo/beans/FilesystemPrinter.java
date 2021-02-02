package com.klezovich.dependencyinjectiondemo.beans;

import lombok.extern.slf4j.Slf4j;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Slf4j
public class FilesystemPrinter implements Printer {

    @PostConstruct
    void init() {
        log.error("Hello from @PostConstruct!");
    }

    void initBean() {
        log.error("Hello from init-method of bean");
    }

    @PreDestroy
    void destroy() {
        log.error("Hello from destroy!");
    }


    @Override
    public void print(String message) {
        log.info("::printing to file system: " + message);
    }
}
