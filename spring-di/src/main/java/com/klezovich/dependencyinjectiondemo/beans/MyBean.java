package com.klezovich.dependencyinjectiondemo.beans;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class MyBean {

    @Value("${app.id}")
    private String id;

    @Value("${app.alias}")
    private String alias;
}
