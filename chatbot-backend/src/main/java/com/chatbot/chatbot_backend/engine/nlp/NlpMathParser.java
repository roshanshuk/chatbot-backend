package com.chatbot.chatbot_backend.engine.nlp;

public final class NlpMathParser {

    private NlpMathParser() {}

    public static String toExpression(String input) {

        input = input.toLowerCase();

     // Hinglish percent
        input = input.replaceAll(
            "(\\d+(?:\\.\\d+)?)\\s*ka\\s*(\\d+(?:\\.\\d+)?)\\s*percent",
            "($1 * $2 / 100)"
        );

        // English percent
        input = input.replaceAll(
            "(\\d+(?:\\.\\d+)?)\\s*percent\\s*of\\s*(\\d+(?:\\.\\d+)?)",
            "($2 * $1 / 100)"
        );

        // power
        input = input.replaceAll(
                "(\\d+)\\s*power\\s*(\\d+)",
                "pow($1,$2)"
        );

        // square root
        input = input.replaceAll(
                "square root of (\\d+)",
                "sqrt($1)"
        );

        // basic operations
        input = input.replaceAll("add (\\d+) and (\\d+)", "$1 + $2");
        input = input.replaceAll("subtract (\\d+) from (\\d+)", "$2 - $1");
        input = input.replaceAll("multiply (\\d+) and (\\d+)", "$1 * $2");
        input = input.replaceAll("divide (\\d+) by (\\d+)", "$1 / $2");

        return input;
    }
}
