package org.example.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class SingletonBean {
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