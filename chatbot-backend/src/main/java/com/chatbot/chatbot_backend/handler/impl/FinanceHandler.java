package com.chatbot.chatbot_backend.handler.impl;

import org.springframework.stereotype.Component;

import com.chatbot.chatbot_backend.engine.MathEngine;
import com.chatbot.chatbot_backend.enums.Intent;
import com.chatbot.chatbot_backend.handler.IntentHandler;

@Component
public class FinanceHandler implements IntentHandler {

    @Override
    public Intent getIntent() {
        return Intent.FINANCE;
    }

    @Override
    public String handle(String message) {
        return MathEngine.solve(message);
    }
}
