package com.chatbot.chatbot_backend.intent.impl;
import com.chatbot.chatbot_backend.enums.Intent;
import com.chatbot.chatbot_backend.intent.IntentRule;

import java.util.regex.Pattern;
public class MathIntentRule implements IntentRule {

    private static final Pattern MATH_PATTERN =
            Pattern.compile(".*(\\d+\\s*[+\\-*/xX]\\s*\\d+).*");

    @Override
    public boolean matches(String message) {
        return MATH_PATTERN.matcher(message).matches();
    }

    @Override
    public Intent getIntent() {
        return Intent.MATH;
    }

    @Override
    public double confidence() {
        return 0.90;
    }
}
