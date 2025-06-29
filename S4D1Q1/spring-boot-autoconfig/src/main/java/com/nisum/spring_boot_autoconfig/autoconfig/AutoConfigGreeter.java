package com.nisum.spring_boot_autoconfig.autoconfig;

import com.nisum.spring_boot_autoconfig.Greeter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
@ConditionalOnMissingBean(Greeter.class)
public class AutoConfigGreeter {
    @Bean
    public Greeter greeter() {
        return () -> "[AUTO-CONFIG] Hello!";
    }
}