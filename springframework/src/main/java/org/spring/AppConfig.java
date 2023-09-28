package org.spring;

import org.spring.message.HelloMessage;
import org.spring.message.Message;
import org.spring.messagerenderer.ErrorMessageRenderer;
import org.spring.messagerenderer.MessageRenderer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("org.spring")
public class AppConfig {
    @Bean
    public Message message() {
        return new HelloMessage("Hello");
    }

    @Bean
    public MessageRenderer messageRenderer() {
        return new ErrorMessageRenderer(message());
    }

}
