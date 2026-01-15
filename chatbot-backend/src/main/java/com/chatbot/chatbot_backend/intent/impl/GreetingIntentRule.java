package com.chatbot.chatbot_backend.intent.impl;
import com.chatbot.chatbot_backend.enums.Intent;
import com.chatbot.chatbot_backend.intent.IntentRule;

import java.util.Set;

public class GreetingIntentRule implements IntentRule {

    private static final Set<String> KEYWORDS =
            Set.of("hi", "hello", "hey", "good morning", "good evening");

    @Override
    public boolean matches(String message) {
        return KEYWORDS.stream().anyMatch(message::contains);
    }

    @Override
    public Intent getIntent() {
        return Intent.GREETING;
    }

    @Override
    public double confidence() {
        return 0.95;
    }
}
