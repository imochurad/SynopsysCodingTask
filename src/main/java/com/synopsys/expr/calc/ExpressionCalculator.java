package com.synopsys.expr.calc;

import java.math.BigInteger;

import com.synopsys.expr.calc.tokenizer.Token;

public interface ExpressionCalculator {

	BigInteger calc(Iterable<Token> tokenized);

}
