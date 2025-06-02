package org.example;

import org.example.beans.SingletonBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        SingletonBean bean1 = context.getBean(SingletonBean.class);
        SingletonBean bean2 = context.getBean(SingletonBean.class);

        bean1.increment();
        System.out.println("Bean1 value: " + bean1.getValue());
        System.out.println("Bean2 value: " + bean2.getValue());
        System.out.println("Same instance? " + (bean1 == bean2));
    }
}