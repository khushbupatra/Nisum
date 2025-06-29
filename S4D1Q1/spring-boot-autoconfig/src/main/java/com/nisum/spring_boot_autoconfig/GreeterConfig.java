package com.nisum.spring_boot_autoconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GreeterConfig {
    @Bean
    public Greeter javaConfigGreeter() {
        return () -> "Hello from Java Config!";
    }
}