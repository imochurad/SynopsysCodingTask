package com.synopsys.expr.calc;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.annotations.VisibleForTesting;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.synopsys.expr.calc.di.ExprCalcModule;
import com.synopsys.expr.calc.tokenizer.Tokenizer;

public class ExprCalcMain {

	private static final Logger LOG = LoggerFactory.getLogger(ExprCalcMain.class);
	private static final Injector INJECTOR = Guice.createInjector(new ExprCalcModule());

	public static void main(final String[] args) {
		if (args.length < 1) {
			LOG.warn("You should provide at least one expression for evaluation...");
		} else {
			final Object[] results = evaluate(args);
			LOG.info("-----------results-------------");
			Arrays.asList(results).stream().forEach(result -> LOG.info("{}", result));
		}
	}

	@VisibleForTesting
	static Object[] evaluate(final String[] expressions) {
		final Object[] results = new Object[expressions.length];
		final Tokenizer tokenizer = INJECTOR.getInstance(Tokenizer.class);
		final ExpressionCalculator calculator = INJECTOR.getInstance(ExpressionCalculator.class);
		for (int i = 0; i < expressions.length; i++) {
			try {
				results[i] = calculator.calc(tokenizer.tokenize(expressions[i]));
			} catch (final Exception e) {
				LOG.error("Error evaluating expression: {}", expressions[i], e);
				results[i] = e.getMessage();
			}
		}
		return results;
	}
}
