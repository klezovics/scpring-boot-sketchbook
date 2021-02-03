package com.klezovich.dependencyinjectiondemo.decorator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrinterTest {

    @Test
    void testPrinterDecoration() {
        var printer = new PrinterImpl();
        var logDecoratedPrinter = new PrinterLoggingDecorator(printer);
        var logAndSecurityDecoratedPrinter = new PrinterSecurityDecorator(logDecoratedPrinter);

        logAndSecurityDecoratedPrinter.print();
    }

}