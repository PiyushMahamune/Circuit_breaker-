package com.Circuit;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class ExampleService {

    private static final String CIRCUIT_BREAKER_NAME = "exampleService";

    @CircuitBreaker(name = CIRCUIT_BREAKER_NAME, fallbackMethod = "fallback")
    public String hello() {
    	if (shouldFail()) {
            throw new RuntimeException("Service unavailable");
    	}
        return "Hello World!";
    }

    public String fallback(Throwable t) {
        return "Fallback Hello World!";
    }
    private boolean shouldFail() {
        // Simulate random failures
        return new Random().nextBoolean();
    }
}

