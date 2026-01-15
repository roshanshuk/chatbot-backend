package com.chatbot.chatbot_backend.handler.impl;

import org.springframework.stereotype.Component;

import com.chatbot.chatbot_backend.enums.Intent;
import com.chatbot.chatbot_backend.handler.IntentHandler;

@Component
public class GreetingHandler implements IntentHandler {

    @Override
    public Intent getIntent() {
        return Intent.GREETING;
    }

    @Override
    public String handle(String message) {
        return "Hello! I can solve math problems 😊";
    }
}
