package com.chatbot.chatbot_backend.ai.fallback;

import org.springframework.stereotype.Component;

import com.chatbot.chatbot_backend.ai.service.AiResponseService;
import com.chatbot.chatbot_backend.enums.Intent;
import com.chatbot.chatbot_backend.handler.IntentHandler;

@Component
public class AiFallbackHandler implements IntentHandler {

    private final AiResponseService aiService;

    public AiFallbackHandler(AiResponseService aiService) {
        this.aiService = aiService;
    }

    @Override
    public Intent getIntent() {
        return Intent.UNKNOWN;
    }

    @Override
    public String handle(String message) {

        String systemPrompt = """
        You are a friendly math and finance assistant.
        If the question is unclear, guide the user with examples.
        Keep answers short and helpful.
        """;

        return aiService.generate(systemPrompt, message);
    }
}
