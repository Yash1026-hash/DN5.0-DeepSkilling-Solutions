package com.dn5.spring;

import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService {

    @Override
    public String greet(String name) {
        return "Hello, " + name + "! Welcome to Spring.";
    }
}
