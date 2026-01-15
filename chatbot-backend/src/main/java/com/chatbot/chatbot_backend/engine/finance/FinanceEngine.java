package com.chatbot.chatbot_backend.engine.finance;

import java.math.BigDecimal;
import java.math.MathContext;

public final class FinanceEngine {

    private static final MathContext MC = new MathContext(20);

    private FinanceEngine() {}

    // Simple Interest
    public static BigDecimal simpleInterest(
            BigDecimal p, BigDecimal r, BigDecimal t) {

        return p.multiply(r).multiply(t)
                .divide(BigDecimal.valueOf(100), MC);
    }

    // Compound Interest
    public static BigDecimal compoundInterest(
            BigDecimal p, BigDecimal r, BigDecimal t) {

        BigDecimal rate = BigDecimal.ONE
                .add(r.divide(BigDecimal.valueOf(100), MC));

        return p.multiply(rate.pow(t.intValue(), MC))
                .subtract(p);
    }

    // EMI
    public static BigDecimal emi(
            BigDecimal p, BigDecimal r, BigDecimal n) {

        BigDecimal monthlyRate =
                r.divide(BigDecimal.valueOf(1200), MC);

        BigDecimal onePlusRPowerN =
                monthlyRate.add(BigDecimal.ONE)
                        .pow(n.intValue(), MC);

        return p.multiply(monthlyRate)
                .multiply(onePlusRPowerN)
                .divide(onePlusRPowerN.subtract(BigDecimal.ONE), MC);
    }

    // CAGR
    public static BigDecimal cagr(
            BigDecimal start, BigDecimal end, BigDecimal years) {

        BigDecimal ratio = end.divide(start, MC);
        return ratio.pow(
                BigDecimal.ONE.divide(years, MC).intValue(), MC)
                .subtract(BigDecimal.ONE)
                .multiply(BigDecimal.valueOf(100));
    }
}
