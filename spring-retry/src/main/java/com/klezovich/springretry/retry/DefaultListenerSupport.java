package com.klezovich.springretry.retry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.listener.RetryListenerSupport;

public class DefaultListenerSupport extends RetryListenerSupport {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public <T, E extends Throwable> void close(
        RetryContext context,
        RetryCallback<T, E> callback, Throwable throwable
    ) {
        log.info("onClose");
        super.close(context, callback, throwable);
    }

    @Override
    public <T, E extends Throwable> void onError(
        RetryContext context,
        RetryCallback<T, E> callback, Throwable throwable
    ) {
        log.info("onError");
        super.onError(context, callback, throwable);
    }

    @Override
    public <T, E extends Throwable> boolean open(
        RetryContext context,
        RetryCallback<T, E> callback
    ) {
        log.info("onOpen");
        return super.open(context, callback);
    }
}