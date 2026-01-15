package com.chatbot.chatbot_backend.intent.impl;
import com.chatbot.chatbot_backend.enums.Intent;
import com.chatbot.chatbot_backend.intent.IntentRule;

import java.util.Set;

public class CustomIntentRule implements IntentRule {

    private static final Set<String> TRIGGERS =
            Set.of("vi", "ro", "pr", "am");

    @Override
    public boolean matches(String message) {
        return TRIGGERS.stream().anyMatch(message::contains);
    }

    @Override
    public Intent getIntent() {
        return Intent.CUSTOM;
    }

    @Override
    public double confidence() {
        return 0.85;
    }
}
