package com.chatbot.chatbot_backend.serviceImpl;

import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.stereotype.Service;

import com.chatbot.chatbot_backend.enums.Intent;
import com.chatbot.chatbot_backend.handler.IntentDispatcher;
import com.chatbot.chatbot_backend.service.ChatService;
import com.chatbot.chatbot_backend.util.IntentDetector;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ChatServiceImpl implements ChatService {

    private final IntentDispatcher dispatcher;
    private final OllamaChatModel chatModel;

    public ChatServiceImpl(IntentDispatcher dispatcher,
                           OllamaChatModel chatModel) {
        this.dispatcher = dispatcher;
        this.chatModel = chatModel;
    }

    @Override
    public String process(String message) {
    	log.info("➡️ Incoming user message: {}", message);

        Intent intent = IntentDetector.detect(message);
        log.info("🧠 Detected intent: {}", intent);

        // Known intent → business logic
        if (intent != Intent.UNKNOWN) {
        	String response =  dispatcher.dispatch(intent, message);
            log.info("✅ Intent response: {}", response);
            return response;
        }

        long start = System.currentTimeMillis();

        log.info("🚀 Sending request to Ollama...");
        String response = chatModel.call(message);

        long end = System.currentTimeMillis();
        log.info("✅ Ollama responded in {} ms", (end - start));
        log.info("🤖 Ollama response: {}", response);
        // Unknown intent → Ollama LLM
        return response;
    }
}	
