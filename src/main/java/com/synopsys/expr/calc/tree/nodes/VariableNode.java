package com.synopsys.expr.calc.tree.nodes;

import java.math.BigInteger;
import java.util.Map;

import com.google.common.base.Preconditions;

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
	public BigInteger doCompute(final Map<String, BigInteger> varValues) {
		return varValues.get(variable);
	}

	@Override
	protected void validateState(final Map<String, BigInteger> varValues) {
		Preconditions.checkState(getChildren().isEmpty(), "Variable node should not have children!");
		Preconditions.checkState(variable != null, "Variable node couldn't be empty!");
		Preconditions.checkState(varValues.get(variable) != null, "Uh oh, unable to detect variable value " + variable);
	}

}