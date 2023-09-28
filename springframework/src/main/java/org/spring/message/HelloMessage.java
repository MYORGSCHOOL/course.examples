package org.spring.message;

public class HelloMessage implements Message {
    private String text;

    public HelloMessage(String text) {
        this.text = text;
    }

    @Override
    public String getText() {
        return text;
    }
}
