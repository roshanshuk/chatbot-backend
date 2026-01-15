package com.chatbot.chatbot_backend.engine;

import net.objecthunter.exp4j.function.Function;

public final class CustomFunctions {

    private CustomFunctions() {}

    public static final Function SQRT =
            new Function("sqrt", 1) {
                @Override
                public double apply(double... args) {
                    return Math.sqrt(args[0]);
                }
            };

    public static final Function POW =
            new Function("pow", 2) {
                @Override
                public double apply(double... args) {
                    return Math.pow(args[0], args[1]);
                }
            };

    public static final Function FACTORIAL =
            new Function("fact", 1) {
                @Override
                public double apply(double... args) {
                    int n = (int) args[0];
                    if (n < 0) throw new IllegalArgumentException();
                    double result = 1;
                    for (int i = 2; i <= n; i++) result *= i;
                    return result;
                }
            };

    public static final Function PERCENT =
            new Function("percent", 1) {
                @Override
                public double apply(double... args) {
                    return args[0] / 100;
                }
            };
}
