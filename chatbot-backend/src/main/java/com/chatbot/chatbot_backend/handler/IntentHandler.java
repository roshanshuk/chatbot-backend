package com.chatbot.chatbot_backend.handler;

import com.chatbot.chatbot_backend.enums.Intent;

public interface IntentHandler {

    Intent getIntent();

    String handle(String message);
}
