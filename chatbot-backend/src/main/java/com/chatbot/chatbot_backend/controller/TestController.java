package com.chatbot.chatbot_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chatbot.chatbot_backend.ai.service.AiResponseService;

@RestController
public class TestController {

	@Autowired
    AiResponseService aiResponseService;

    @GetMapping("/ai-test")
    public String test() {
        return aiResponseService.generate(
            "You are a test assistant",
            "Say hello in one sentence"
        );
    }
}
