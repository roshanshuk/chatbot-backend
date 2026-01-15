package com.chatbot.chatbot_backend.intent.impl;

import com.chatbot.chatbot_backend.enums.Intent;
import com.chatbot.chatbot_backend.intent.IntentRule;
public class UnknownIntentRule implements IntentRule {

    @Override
    public boolean matches(String message) {
        return true;
    }

    @Override
    public Intent getIntent() {
        return Intent.UNKNOWN;
    }

    @Override
    public double confidence() {
        return 0.50;
    }
}

