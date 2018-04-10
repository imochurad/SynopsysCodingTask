package com.synopsys.expr.calc.tree.nodes;

import java.math.BigInteger;
import java.util.Map;

import com.google.common.base.Preconditions;
import com.synopsys.expr.calc.tree.TreeNode;

public class LetNode extends OperatorNode {

	@Override
	public String getData() {
		return "$";
	}

	@Override
	public BigInteger doCompute(final Map<String, BigInteger> varValues) {
		final TreeNode firstChild = getChildren().get(0);
		final VariableNode varNode = (VariableNode) firstChild;
		final BigInteger varValue = getChildren().get(1).compute(varValues);
		varValues.put(varNode.getVariable(), varValue);
		final BigInteger result = getChildren().get(2).compute(varValues);
		varValues.remove(varNode.getVariable());
		return result;
	}

	@Override
	public void validateState(final Map<String, BigInteger> varValues) {
		Preconditions.checkState(getChildren().size() == 3, "LetNode must contain 3 child nodes!");
		Preconditions.checkState(getChildren().get(0) instanceof VariableNode,
				"First child of let node must be variable name");
		// TODO add other checks
	}

}