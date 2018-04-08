package com.synopsys.expr.calc.tokenizer;

public interface Tokenizer {

	Iterable<Token> tokenize(String input);

}