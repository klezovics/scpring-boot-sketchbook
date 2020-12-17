package com.klezovich.springretry.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.retry.support.RetryTemplate;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest
public class MyServiceRetryTest {

    @Autowired
    private MyService service;

    @Autowired
    private RetryTemplate retryTemplate;

    @BeforeEach
    void setup() {
        service.resetRetryCounter();
    }

    @Test
    void testRetry() {
        service.retry(-1);
        assertThat(service.getRetryCount(), is(2));
    }

    @Test
    void testRetryAndRecover() {
        service.retryAndRecover(-1);
        assertThat(service.getRetryCount(), is(3));
    }

    @Test
    public void givenTemplateRetryService_whenCallWithException_thenRetry() {
        retryTemplate.execute(arg0 -> {
            service.retry(-1);
            return null;
        });
    }
}
