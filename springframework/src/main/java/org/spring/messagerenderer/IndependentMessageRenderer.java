package org.spring.messagerenderer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IndependentMessageRenderer {


    MessageRenderer messageRenderer;

    public void print(){
        messageRenderer.printMessage();
    }

    @Autowired
    public void setMessageRenderer(MessageRenderer messageRenderer) {
        this.messageRenderer = messageRenderer;
    }
}
