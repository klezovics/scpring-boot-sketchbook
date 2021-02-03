package com.klezovich.dependencyinjectiondemo.decorator;


public class PrinterImpl implements Printer {
    @Override
    public void print() {
        System.out.println("Hello from printer");
    }
}
