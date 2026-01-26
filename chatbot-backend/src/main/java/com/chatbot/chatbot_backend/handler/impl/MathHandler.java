package com.chatbot.chatbot_backend.handler.impl;

import org.springframework.stereotype.Component;

import com.chatbot.chatbot_backend.ai.service.AiResponseService;
import com.chatbot.chatbot_backend.engine.MathEngine;
import com.chatbot.chatbot_backend.enums.Intent;
import com.chatbot.chatbot_backend.handler.IntentHandler;

@Component
public class MathHandler implements IntentHandler {

	 private final AiResponseService aiService;

	    public MathHandler(AiResponseService aiService) {
	        this.aiService = aiService;
	    }

	    @Override
	    public Intent getIntent() {
	        return Intent.MATH;
	    }

	    @Override
	    public String handle(String message) {

	        String rawResult = MathEngine.solve(message);

	        String systemPrompt = """
	        You explain math results in simple Hinglish.
	        Do not change the calculation.
	        Keep it short.
	        """;

	        return aiService.generate(systemPrompt,
	                "Question: " + message + "\nAnswer: " + rawResult);
	    }
	}
