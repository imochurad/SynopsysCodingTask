package com.synopsys.expr.calc.tree.nodes;

import java.math.BigInteger;

public class MultNode extends BinaryOperatorNode {

	@Override
	public String getData() {
		return "*";
	}

	@Override
	protected BigInteger apply(final BigInteger leftExpressionResult, final BigInteger rightExpressionResult) {
		return leftExpressionResult.multiply(rightExpressionResult);
	}

}