package com.chatbot.chatbot_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chatbot.chatbot_backend.dto.ChatRequest;
import com.chatbot.chatbot_backend.dto.ChatResponse;
import com.chatbot.chatbot_backend.service.ChatService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/chat")
public class ChatController {
	
	@Autowired
	private ChatService chatService;
    
    @PostMapping
    public ChatResponse chat(@RequestBody ChatRequest request) {
        return new ChatResponse(chatService.process(request.getMessage()));
    }
}

