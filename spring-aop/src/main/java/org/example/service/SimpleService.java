package org.example.service;

import org.example.annotation.LogMethodInfo;
import org.springframework.stereotype.Service;

@Service
public class SimpleService {
    @LogMethodInfo
    public void method() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @LogMethodInfo
    public String methodWithReturn(String arg) {
        return arg;
    }
}
