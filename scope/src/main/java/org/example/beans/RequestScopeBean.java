package org.example.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class RequestScopeBean {
    private int value = 0;

    public int getValue() {
        return value;
    }

    public void increment() {
        value++;
    }
}