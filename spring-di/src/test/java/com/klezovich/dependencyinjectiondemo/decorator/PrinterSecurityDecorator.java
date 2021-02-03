package com.klezovich.dependencyinjectiondemo.decorator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PrinterSecurityDecorator implements Printer {

    private final Printer printer;

    public PrinterSecurityDecorator(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void print() {
       log.info("Doing security checks BEFORE logging ...");
       printer.print();
       log.info("Doing security checks AFTER logging ...");
    }
}
