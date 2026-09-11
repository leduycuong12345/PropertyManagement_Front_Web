package com.cuongsolution.manageproperty.front.web.Configuration;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@EnableAsync
public class AsyncConfig implements AsyncConfigurer { // for send verfication-email
	
    @Override
    public Executor getAsyncExecutor() {
        return Executors.newFixedThreadPool(5);
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return (throwable, method, params) -> {
            System.err.println("Async error in " + method.getName() + ": " + throwable.getMessage());
            throwable.printStackTrace();
        };
    }
}