package com.klezovich.dependencyinjectiondemo.beans;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@ToString
@Slf4j
public class StringPair implements ApplicationContextAware {

    private final String first;

    @Value("two")
    private String second;

    @Autowired
    public StringPair( @Value("one") String first) {
        this.first = first;

    }

    @PostConstruct
    public void print() {
        log.error(this.toString());
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        log.error(applicationContext.toString());
        log.error(applicationContext.getEnvironment().toString());
        log.error(applicationContext.getBeanDefinitionNames().toString());
        log.error(applicationContext.getApplicationName());
        log.error(applicationContext.getId());
        log.error("{}",applicationContext.getStartupDate());
    }
}
