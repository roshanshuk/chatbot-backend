package com.chatbot.chatbot_backend.handler.impl;

import org.springframework.stereotype.Component;

import com.chatbot.chatbot_backend.enums.Intent;
import com.chatbot.chatbot_backend.handler.IntentHandler;

import java.util.Map;

@Component
public class CustomHandler implements IntentHandler {

    private static final Map<String, String> RESPONSES = Map.of(
            "vi", "I thought you are VIBHU",
            "ro", "I thought you are ROSHAN",
            "pr", "I thought you are PRIYANSHI",
            "am", "I thought you are AMAN"
    );

    @Override
    public Intent getIntent() {
        return Intent.CUSTOM;
    }

    @Override
    public String handle(String message) {
        return RESPONSES.entrySet()
                .stream()
                .filter(e -> message.contains(e.getKey()))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElse("No keyword found");
    }
}
