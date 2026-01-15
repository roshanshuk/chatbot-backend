package com.chatbot.chatbot_backend.handler.impl;
import org.springframework.stereotype.Component;

import com.chatbot.chatbot_backend.enums.Intent;
import com.chatbot.chatbot_backend.handler.IntentHandler;

@Component
public class UnknownHandler implements IntentHandler {

    @Override
    public Intent getIntent() {
        return Intent.UNKNOWN;
    }

    @Override
    public String handle(String message) {
        return "Sorry, I didn't understand.";
    }
}
