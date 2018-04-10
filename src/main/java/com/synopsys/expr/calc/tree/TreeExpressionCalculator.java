package com.synopsys.expr.calc.tree;

import java.math.BigInteger;

import com.synopsys.expr.calc.ExpressionCalculator;
import com.synopsys.expr.calc.tokenizer.Token;

public class TreeExpressionCalculator implements ExpressionCalculator {

	private final TreePrinter treePrinter = new TreePrinter();

	@Override
	public BigInteger calc(final Iterable<Token> tokenized) {
		final TreeNode node = new TreeBuilder(tokenized).build();
		treePrinter.print(node);
		return node.compute();
	}

}