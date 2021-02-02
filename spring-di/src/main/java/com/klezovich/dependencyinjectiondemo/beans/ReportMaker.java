package com.klezovich.dependencyinjectiondemo.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Component
public class ReportMaker {

    private final Printer printer;

    @Autowired
    public ReportMaker(Printer printer) {
        this.printer = printer;
    }

    public void makeReport() {
        var report = "Everything is good";
        printer.print(report);
    }
}
