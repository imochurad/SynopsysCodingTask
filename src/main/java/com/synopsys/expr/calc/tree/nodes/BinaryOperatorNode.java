package com.synopsys.expr.calc.tree.nodes;

import java.math.BigInteger;
import java.util.Map;

public abstract class BinaryOperatorNode extends OperatorNode {

	@Override
	public BigInteger doCompute(final Map<String, BigInteger> varValues) {
		return apply(getChildren().get(0).compute(varValues), getChildren().get(1).compute(varValues));
	}

	protected abstract BigInteger apply(BigInteger leftExpressionResult, BigInteger rightExpressionResult);

	@Override
	protected void validateState(final Map<String, BigInteger> varValues) {
		// do nothing
	}

}