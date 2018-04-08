package com.synopsys.expr.calc.tokenizer.impl;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.synopsys.expr.calc.tokenizer.Token;
import com.synopsys.expr.calc.tokenizer.TokenType;

public class TokenClassifier {

	public Iterable<Token> classify(final Iterable<String> unclassified) {
		return StreamSupport.stream(unclassified.spliterator(), false).map(this::classify).collect(Collectors.toList());
	}

	private Token classify(final String unclassified) {
		final Optional<TokenType> tokenTypeOpt = Arrays.asList(TokenType.values()).stream()
				.filter(tt -> unclassified.matches(tt.getRegex())).findFirst();
		final TokenType tokenType = tokenTypeOpt.orElseThrow(
				() -> new IllegalTokenException("Unable to determine token type for token: " + unclassified));
		return new Token(tokenType, unclassified);
	}

	class IllegalTokenException extends RuntimeException {

		private static final long serialVersionUID = 1L;

		public IllegalTokenException(final String msg) {
			super(msg);
		}

	}

}