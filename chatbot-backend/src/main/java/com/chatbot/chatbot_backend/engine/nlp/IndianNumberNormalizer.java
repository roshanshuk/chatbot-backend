package com.chatbot.chatbot_backend.engine.nlp;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class IndianNumberNormalizer {

    private IndianNumberNormalizer() {}

    public static String normalize(String input) {
        input = input.toLowerCase();
        input = replace(input, "(\\d+(?:\\.\\d+)?)\\s*hazar",
                m -> mul(m.group(1), "1000"));
        input = replace(input, "(\\d+(?:\\.\\d+)?)\\s*lakh",
                m -> mul(m.group(1), "100000"));
        input = replace(input, "(\\d+(?:\\.\\d+)?)\\s*crore",
                m -> mul(m.group(1), "10000000"));
        return input;
    }

    private static String mul(String v, String f) {
        return new BigDecimal(v)
                .multiply(new BigDecimal(f))
                .stripTrailingZeros()
                .toPlainString();
    }

    private static String replace(String input, String regex,
                                  java.util.function.Function<Matcher,String> fn) {
        Matcher m = Pattern.compile(regex).matcher(input);
        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            m.appendReplacement(sb,
                Matcher.quoteReplacement(fn.apply(m)));
        }
        m.appendTail(sb);
        return sb.toString();
    }
}