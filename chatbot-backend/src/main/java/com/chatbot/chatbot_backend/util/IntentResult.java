package com.chatbot.chatbot_backend.util;

import com.chatbot.chatbot_backend.enums.Intent;

public record IntentResult(Intent intent, double confidence) {
}
