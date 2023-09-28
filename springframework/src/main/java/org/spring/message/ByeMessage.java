package org.spring.message;

public class ByeMessage implements Message {
    private String text;

    public ByeMessage(String text) {
        this.text = text;
    }

    @Override
    public String getText() {
        return text;
    }
}
