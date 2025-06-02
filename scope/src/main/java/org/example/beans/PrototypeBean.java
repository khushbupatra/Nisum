package org.example.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class PrototypeBean {
    private int value = 0;

    public int getValue() {
        return value;
    }

    public void increment() {

            value++;
        }
    }
