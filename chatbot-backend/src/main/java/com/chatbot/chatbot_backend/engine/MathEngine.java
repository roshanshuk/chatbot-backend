package com.chatbot.chatbot_backend.engine;

import com.chatbot.chatbot_backend.engine.nlp.AdvancedNlpFinanceParser;
import com.chatbot.chatbot_backend.engine.nlp.HindiFractionNormalizer;
import com.chatbot.chatbot_backend.engine.nlp.IndianNumberNormalizer;
import com.chatbot.chatbot_backend.engine.nlp.NlpFinanceParser;
import com.chatbot.chatbot_backend.engine.nlp.NlpMathParser;

public final class MathEngine {

	private MathEngine() {
	}

	public static String solve(String input) {

		// 1️⃣ Indian number normalization
		input = IndianNumberNormalizer.normalize(input);

		// 1) Hindi fractions → numbers
		input = HindiFractionNormalizer.normalize(input);

		// 2️⃣ Finance NLP
		String finance = AdvancedNlpFinanceParser.parse(input);
		if (finance != null)
			return finance;

		String basicFinance = NlpFinanceParser.parse(input);
		if (basicFinance != null)
			return basicFinance;

		// 3️⃣ NLP math → expression → evaluate
		String expr = NlpMathParser.toExpression(input);
		return ExpressionMathEngine.evaluate(expr);
	}
}
