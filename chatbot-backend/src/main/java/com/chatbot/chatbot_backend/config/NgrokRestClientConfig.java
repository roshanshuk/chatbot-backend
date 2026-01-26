package com.chatbot.chatbot_backend.config;

import org.springframework.boot.web.client.RestClientCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NgrokRestClientConfig {

    @Bean
    public RestClientCustomizer ngrokRestClientCustomizer() {
        return builder -> builder
                .defaultHeader("ngrok-skip-browser-warning", "true");
    }
}
