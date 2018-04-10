package com.synopsys.expr.calc.tree.nodes;

import java.math.BigInteger;
import java.util.Map;

import com.google.common.base.Preconditions;

public class ValueNode extends OperandNode {

	private final BigInteger value;

	public ValueNode(final BigInteger value) {
		this.value = value;
	}

	public BigInteger getValue() {
		return value;
	}

	@Override
	public String getData() {
		return "" + getValue();
	}

	@Override
	protected BigInteger doCompute(final Map<String, BigInteger> varValues) {
		return getValue();
	}

	@Override
	protected void validateState(final Map<String, BigInteger> varValues) {
		Preconditions.checkState(getChildren().isEmpty(), "Value node should not have children!");
		Preconditions.checkState(value != null, "Value node couldn't be empty!");
	}

}