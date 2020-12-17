package com.klezovich.springretry;

import com.klezovich.springretry.retry.DefaultListenerSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.listener.RetryListenerSupport;
import org.springframework.retry.support.RetryTemplate;

@SpringBootApplication
@EnableRetry
public class SpringRetryApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringRetryApplication.class, args);
    }

    @Bean
    public RetryTemplate retryTemplate() {

        RetryTemplate retryTemplate = new RetryTemplate();
        retryTemplate.registerListener(new DefaultListenerSupport());
        return retryTemplate;
    }
}
