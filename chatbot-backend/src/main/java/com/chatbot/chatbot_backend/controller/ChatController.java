package com.chatbot.chatbot_backend.controller;

import java.util.UUID;

import org.slf4j.MDC;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chatbot.chatbot_backend.dto.ChatRequest;
import com.chatbot.chatbot_backend.dto.ChatResponse;
import com.chatbot.chatbot_backend.service.ChatService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequestMapping("/api/chat")
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping
    public ChatResponse chat(@RequestBody ChatRequest request) {
    	String requestId = UUID.randomUUID().toString();
        MDC.put("requestId", requestId);

        log.info("🆔 Incoming request");
        return new ChatResponse(chatService.process(request.getMessage()));
    }
}

