package org.example.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(WebApplicationContext.SCOPE_SESSION)
public class SessionScopeBean {
    private int value = 0;

    public int getValue() {
        return value;
    }

    public void increment() {
        if (value < 1) {
            value++;
        }
    }
}