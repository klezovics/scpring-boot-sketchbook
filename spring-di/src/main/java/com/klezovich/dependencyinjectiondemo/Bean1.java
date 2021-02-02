package com.klezovich.dependencyinjectiondemo;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

@Getter
public class Bean1 {

    @Value("Arthur Klezovich")
    private String beanAuthor;

    @Value("${app.file.value}")
    private String valueFromFile;

    @Value("42")
    private int answerToAll;

    @Value("#{50+50}")
    private int sum;

    @Value("${app.jvm.value}")
    private String valueFromJvm;

    @Value("${MY_ENV}")
    private String valueFromEnv;

    @Value("#{@srcBean.srcField}")
    private String fromSrcBeanField;

    @Value("#{@srcBean.srcMethod()}")
    private String fromSrcMethodField;

    @Value("true")
    private boolean myBoolean;

    @Value("#{(new java.util.Date()).toString()}")
    private String dateStr;

    private String fromSetter;

    private final String fromConstructor;

    private String fromDoubleSetter1;

    private String fromDoubleSetter2;

    @Autowired
    public Bean1(@Value("forConstructor") String fromConstructor) {
        this.fromConstructor = fromConstructor;
    }

    @Autowired
    public void setFromSetter(@Value("forSetter") String fromSetter) {
        this.fromSetter = fromSetter;
    }

    @Value("both_values")
    public void setBoth(String one, String two) {
        fromDoubleSetter1=one;
        fromDoubleSetter2=two;
    }


}
