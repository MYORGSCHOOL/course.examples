package org.spring.messagerenderer;

import org.spring.message.Message;
import org.springframework.stereotype.Component;

@Component
public class ErrorMessageRenderer implements MessageRenderer {
    private Message message;

    public ErrorMessageRenderer(Message message) {
        this.message = message;
    }

    public void printMessage() {
        System.err.println(message.getText());
    }
}
