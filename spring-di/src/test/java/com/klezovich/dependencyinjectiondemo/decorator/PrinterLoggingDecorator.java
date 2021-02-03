package com.klezovich.dependencyinjectiondemo.decorator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PrinterLoggingDecorator implements Printer {

    private final Printer printer;

    public PrinterLoggingDecorator(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void print() {
       log.info("Logging BEFORE print ...");
       printer.print();
       log.info("Logging AFTER print ... ");
    }
}
