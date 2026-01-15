package com.chatbot.chatbot_backend.engine.nlp;

import com.chatbot.chatbot_backend.engine.finance.AdvancedFinanceEngine;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class AdvancedNlpFinanceParser {

    private AdvancedNlpFinanceParser() {}

    public static String parse(String input) {

        input = IndianNumberNormalizer.normalize(input);

        // SIP
        Matcher sip = Pattern.compile(
                "sip of (\\d+) for (\\d+) years at (\\d+)%"
        ).matcher(input);

        if (sip.find()) {
            BigDecimal monthly = new BigDecimal(sip.group(1));
            int months = Integer.parseInt(sip.group(2)) * 12;
            BigDecimal rate = new BigDecimal(sip.group(3));
            return "SIP Value: " +
                    AdvancedFinanceEngine.sip(monthly, rate, months).toPlainString();
        }

        // FD
        Matcher fd = Pattern.compile(
                "fd of (\\d+) for (\\d+) years at (\\d+)%"
        ).matcher(input);

        if (fd.find()) {
            return "FD Maturity: " +
                    AdvancedFinanceEngine.fd(
                            new BigDecimal(fd.group(1)),
                            new BigDecimal(fd.group(3)),
                            Integer.parseInt(fd.group(2))
                    ).toPlainString();
        }

        // GST
        Matcher gst = Pattern.compile(
                "gst (\\d+)% on (\\d+)"
        ).matcher(input);

        if (gst.find()) {
            return "GST Amount: " +
                    AdvancedFinanceEngine.gst(
                            new BigDecimal(gst.group(2)),
                            new BigDecimal(gst.group(1))
                    ).toPlainString();
        }

        return null;
    }
}
