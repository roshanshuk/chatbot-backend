package com.chatbot.chatbot_backend.ai.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class AiResponseService {
	
	private static final Logger log = LoggerFactory.getLogger(AiResponseService.class);

    private final ChatClient chatClient;

    public AiResponseService(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    public String generate(String systemPrompt, String userPrompt) {
        try {
            return chatClient.prompt()
                    .system(systemPrompt)
                    .user(userPrompt)
                    .call()
                    .content();
        } catch (Exception e) {
            log.error("DeepSeek AI call failed", e);

            if (e.getMessage() != null && e.getMessage().contains("Insufficient Balance")) {
                return "⚠️ AI service is temporarily unavailable. Please try again later.";
            }

            return "Sorry, I couldn't process that request right now.";
        }
    }
}
