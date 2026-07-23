package com.dn5.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.dn5.spring")
public class AppConfig {

    @Bean
    public GreetingService greetingService() {
        return new GreetingServiceImpl();
    }
}
