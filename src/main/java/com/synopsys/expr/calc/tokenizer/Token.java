package com.synopsys.expr.calc.tokenizer;

public class Token {

	private final TokenType tokenType;

	private final String data;

	public Token(final TokenType tokenType, final String data) {
		this.tokenType = tokenType;
		this.data = data;
	}

	public TokenType getTokenType() {
		return tokenType;
	}

	public String getData() {
		return data;
	}

	@Override
	public String toString() {
		return "Token [tokenType=" + tokenType + ", data=" + data + "]";
	}

}