package org.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("context.xml");
        Color bean = ac.getBean(Color.class);
        System.out.println(bean.getRed());
    }
}
