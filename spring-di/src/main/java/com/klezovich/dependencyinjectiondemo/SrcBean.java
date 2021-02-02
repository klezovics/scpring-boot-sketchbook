package com.klezovich.dependencyinjectiondemo;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
@Component
public class SrcBean {

    private String srcField = "srcFieldValue";

    public String srcMethod() {
        return "srcMethodValue";
    }
}
