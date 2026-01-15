package com.chatbot.chatbot_backend.serviceImpl;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.chatbot.chatbot_backend.enums.Intent;
import com.chatbot.chatbot_backend.handler.IntentHandler;
import com.chatbot.chatbot_backend.service.ChatService;
import com.chatbot.chatbot_backend.util.IntentDetector;

@Service
public class ChatServiceImpl implements ChatService {

    private final Map<Intent, IntentHandler> handlerMap;

    public ChatServiceImpl(List<IntentHandler> handlers) {
        this.handlerMap = handlers.stream()
                .collect(Collectors.toMap(
                        IntentHandler::getIntent,
                        Function.identity()
                ));
    }

    @Override
    public String process(String message) {

        Intent intent = IntentDetector.detect(message);

        return handlerMap
                .getOrDefault(intent, handlerMap.get(Intent.UNKNOWN))
                .handle(message.toLowerCase());
    }
}
