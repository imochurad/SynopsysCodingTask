package com.synopsys.expr.calc.tokenizer.impl;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.synopsys.expr.calc.tokenizer.Token;
import com.synopsys.expr.calc.tokenizer.Tokenizer;

public class TokenizerImpl implements Tokenizer {

	private static final Logger LOG = LoggerFactory.getLogger(TokenizerImpl.class);

	private final String regex;
	private final TokenClassifier classifier;

	public TokenizerImpl(final String regex) {
		this.regex = regex;
		this.classifier = new TokenClassifier();
	}

	@Override
	public Iterable<Token> tokenize(String input) {
		input = input.replaceAll("\\s", "");
		LOG.debug("Expression before tokenization:{}", input);
		final String[] tokens = input.split(regex);
		final Iterable<String> unclassified = Arrays.asList(tokens).stream().filter(s -> !s.equals(""))
				.collect(Collectors.toList());
		return classifier.classify(unclassified);
	}

}