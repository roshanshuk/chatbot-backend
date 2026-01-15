package com.chatbot.chatbot_backend.util;

import com.chatbot.chatbot_backend.enums.Intent;

public class IntentDetector {

    public static Intent detect(String msg) {

        if (msg == null || msg.isBlank()) {
            return Intent.UNKNOWN;
        }

        msg = msg.toLowerCase();

        // 1️⃣ Greeting
        if (msg.matches(".*\\b(hi|hello|hey)\\b.*")) {
            return Intent.GREETING;
        }

        // 2️⃣ Finance (VERY IMPORTANT)
        if (msg.contains("emi")
                || msg.contains("interest")
                || msg.contains("loan")
                || msg.contains("cagr")
                || msg.contains("rate")
                || msg.contains("%")) {
            return Intent.FINANCE;
        }

        // 3️⃣ NLP / Math expressions
        if (msg.matches(".*(\\d+).*")) {
            return Intent.MATH;
        }

        // 4️⃣ Custom
        if (msg.matches(".*\\b(vi|ro|pr|am)\\b.*")) {
            return Intent.CUSTOM;
        }

        return Intent.UNKNOWN;
    }
}
