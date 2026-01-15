package com.chatbot.chatbot_backend.intent;

import com.chatbot.chatbot_backend.enums.Intent;

public interface IntentRule {

    boolean matches(String message);

    Intent getIntent();

    double confidence();
}
