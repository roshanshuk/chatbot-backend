package com.chatbot.chatbot_backend.engine.nlp;

import java.util.Map;

public final class HindiFractionNormalizer {

    private static final Map<String, String> FRACTIONS = Map.of(
        "aadha", "0.5",
        "pauna", "0.75",
        "sawa", "1.25",
        "dedh", "1.5",
        "dhai", "2.5"
    );

    private HindiFractionNormalizer() {}

    public static String normalize(String input) {

        input = input.toLowerCase();

        for (var e : FRACTIONS.entrySet()) {
            // 🔥 NO word boundary — safe replacement
            input = input.replaceAll(
                "(?<!\\w)" + e.getKey() + "(?!\\w)",
                e.getValue()
            );
        }

        return input;
    }
}
