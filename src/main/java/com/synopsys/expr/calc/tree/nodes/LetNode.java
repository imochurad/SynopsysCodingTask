package com.synopsys.expr.calc.tree.nodes;

import java.math.BigInteger;
import java.util.Map;

import com.synopsys.expr.calc.tree.TreeNode;

public class LetNode extends OperatorNode {

	@Override
	public String getData() {
		return "$";
	}

	@Override
	public BigInteger compute(final Map<String, BigInteger> varValues) {
		final TreeNode firstChild = getChildren().get(0);
		if (!(firstChild instanceof VariableNode)) {
			throw new IllegalStateException("First child of let node must be variable name");
		}
		final VariableNode varNode = (VariableNode) firstChild;
		final BigInteger varValue = getChildren().get(1).compute(varValues);
		varValues.put(varNode.getVariable(), varValue);
		final BigInteger result = getChildren().get(2).compute(varValues);
		varValues.remove(varNode.getVariable());
		return result;
	}

}