package com.chatbot.chatbot_backend.engine.finance;

import java.math.BigDecimal;
import java.math.MathContext;

public final class AdvancedFinanceEngine {

    private static final MathContext MC = new MathContext(20);

    private AdvancedFinanceEngine() {}

    // SIP
    public static BigDecimal sip(BigDecimal monthly, BigDecimal rate, int months) {
        BigDecimal r = rate.divide(BigDecimal.valueOf(1200), MC);
        BigDecimal factor = r.add(BigDecimal.ONE).pow(months, MC);
        return monthly.multiply(factor.subtract(BigDecimal.ONE))
                .divide(r, MC)
                .multiply(r.add(BigDecimal.ONE), MC);
    }

    // FD
    public static BigDecimal fd(BigDecimal p, BigDecimal r, int years) {
        BigDecimal rate = r.divide(BigDecimal.valueOf(100), MC).add(BigDecimal.ONE);
        return p.multiply(rate.pow(years, MC));
    }

    // GST
    public static BigDecimal gst(BigDecimal amount, BigDecimal rate) {
        return amount.multiply(rate)
                .divide(BigDecimal.valueOf(100), MC);
    }
}
