package com.chatbot.chatbot_backend.engine;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public final class ExpressionMathEngine {

    private ExpressionMathEngine() {}

    public static String evaluate(String expr) {
        try {
            Expression e = new ExpressionBuilder(expr)
                    .functions(CustomFunctions.SQRT, CustomFunctions.POW)
                    .build();

            return "Result: " + e.evaluate();
        } catch (Exception ex) {
            return "Invalid calculation ❌";
        }
    }
}
