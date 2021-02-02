package com.klezovich.dependencyinjectiondemo.beans;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RestApiPrinter implements Printer {

    @Override
    public void print(String message) {
        log.info("::printing to REST API: " + message);
    }
}
