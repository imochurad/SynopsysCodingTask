package com.synopsys.expr.calc.tree.nodes;

import java.math.BigInteger;
import java.util.Map;

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
	public BigInteger compute(final Map<String, BigInteger> varValues) {
		return getValue();
	}

}