package org.spring.messagerenderer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IndependentMessageRenderer {

    @Autowired
    MessageRenderer messageRenderer;

    public IndependentMessageRenderer(MessageRenderer messageRenderer) {
        this.messageRenderer = messageRenderer;
    }
    public void print(){
        messageRenderer.printMessage();
    }
}
