package com.synopsys.expr.calc.tokenizer;

public enum TokenType {

	VARIABLE("[a-zA-Z]"), VALUE("\\d+"), LET("let"), ADD("add"), SUB("sub"), MULT("mult"), DIV("div");

	private final String regex;

	TokenType(final String regex) {
		this.regex = regex;
	}

	public String getRegex() {
		return regex;
	}

}