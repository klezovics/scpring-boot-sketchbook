package com.klezovich.springretry.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
public class MyService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private int retryCount=0;

    @Retryable(value = RuntimeException.class)
    void retry(Integer number) {
        log.info("Try to execute retryService...");

        if( number != 0  && retryCount < 2) {
            retryCount++;
            log.info("FAIL !");
            throw new RuntimeException();
        }

        log.info("SUCCESS !");
        return;
    }

    @Retryable(value = RuntimeException.class)
    void retryAndRecover(Integer number) {
        retryCount++;
        throw new RuntimeException();
    }

    @Recover
    void recoveryMethod() {
        log.info("Hello from recovery method!");
    }

    public int getRetryCount() {
        return retryCount;
    }

    public void resetRetryCounter() {
        retryCount=0;
    }
}
