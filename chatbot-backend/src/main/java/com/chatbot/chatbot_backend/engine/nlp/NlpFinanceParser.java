package com.chatbot.chatbot_backend.engine.nlp;

import com.chatbot.chatbot_backend.engine.finance.FinanceEngine;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class NlpFinanceParser {

    private NlpFinanceParser() {}

    public static String parse(String input) {

        input = input.toLowerCase();

        // EMI
        Matcher emi = Pattern.compile(
                "emi of (\\d+) for (\\d+) years at (\\d+)%"
        ).matcher(input);

        if (emi.find()) {
            BigDecimal p = new BigDecimal(emi.group(1));
            BigDecimal n = new BigDecimal(emi.group(2)).multiply(BigDecimal.valueOf(12));
            BigDecimal r = new BigDecimal(emi.group(3));

            return "EMI: " + FinanceEngine.emi(p, r, n).toPlainString();
        }

        // Simple Interest
        Matcher si = Pattern.compile(
                "simple interest of (\\d+) at (\\d+)% for (\\d+) years"
        ).matcher(input);

        if (si.find()) {
            return "Simple Interest: " +
                    FinanceEngine.simpleInterest(
                            new BigDecimal(si.group(1)),
                            new BigDecimal(si.group(2)),
                            new BigDecimal(si.group(3))
                    );
        }

        // Compound Interest
        Matcher ci = Pattern.compile(
                "compound interest of (\\d+) at (\\d+)% for (\\d+) years"
        ).matcher(input);

        if (ci.find()) {
            return "Compound Interest: " +
                    FinanceEngine.compoundInterest(
                            new BigDecimal(ci.group(1)),
                            new BigDecimal(ci.group(2)),
                            new BigDecimal(ci.group(3))
                    );
        }

        return null;
    }
}
