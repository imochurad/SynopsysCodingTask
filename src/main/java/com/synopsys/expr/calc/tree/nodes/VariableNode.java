package com.synopsys.expr.calc.tree.nodes;

import java.math.BigInteger;
import java.util.Map;

public class VariableNode extends OperandNode {

	private final String variable;

	public VariableNode(final String variable) {
		this.variable = variable;
	}

	public String getVariable() {
		return variable;
	}

	@Override
	public String getData() {
		return variable;
	}

	@Override
	public BigInteger compute(final Map<String, BigInteger> varValues) {
		final BigInteger varValue = varValues.get(variable);
		if (varValue == null) {
			throw new IllegalStateException("Uh oh, unable to detect variable value" + variable);
		}
		return varValue;
	}

}