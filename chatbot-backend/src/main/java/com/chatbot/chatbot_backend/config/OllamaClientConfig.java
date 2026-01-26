package com.chatbot.chatbot_backend.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class OllamaClientConfig {

    @Bean
    public RestClient ollamaRestClient() {
        return RestClient.builder()
                .defaultHeader("ngrok-skip-browser-warning", "true")
                .build();
    }
}
