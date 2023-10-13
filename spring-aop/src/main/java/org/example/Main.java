package org.example;

import org.example.service.SimpleService;
import org.example.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class Main implements CommandLineRunner {

    @Autowired
    SimpleService service;
    @Autowired
    TestService testService;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        service.methodWithReturn("aparm");
        service.method();
        testService.testMethod();
    }
}
