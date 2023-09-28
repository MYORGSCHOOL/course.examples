package org.spring.messagerenderer;

import org.spring.message.Message;

public class StandardMessageRenderer implements MessageRenderer {
    private Message message;

    public StandardMessageRenderer(Message message) {
        this.message = message;
    }

    public void printMessage() {
        System.out.println(message.getText());
    }
}
