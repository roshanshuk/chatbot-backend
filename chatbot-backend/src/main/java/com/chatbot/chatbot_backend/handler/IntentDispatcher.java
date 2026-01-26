package com.chatbot.chatbot_backend.handler;

import java.util.List;

import org.springframework.stereotype.Component;

import com.chatbot.chatbot_backend.enums.Intent;

@Component
public class IntentDispatcher {

    private final List<IntentHandler> handlers;

    public IntentDispatcher(List<IntentHandler> handlers) {
        this.handlers = handlers;
    }

    public String dispatch(Intent intent, String message) {

        return handlers.stream()
                .filter(h -> h.getIntent() == intent)
                .findFirst()
                .orElseThrow(() ->
                        new IllegalStateException("No handler for intent: " + intent))
                .handle(message);
    }
}
