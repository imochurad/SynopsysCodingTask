package com.synopsys.expr.calc.tree;

import java.math.BigInteger;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class TreeNode {

	protected List<TreeNode> children = Collections.emptyList();

	public List<TreeNode> getChildren() {
		return children;
	}

	public abstract String getData();

	public abstract boolean isLeafNode();

	public BigInteger compute() {
		return compute(new HashMap<>());
	}

	public BigInteger compute(final Map<String, BigInteger> varValues) {
		validateState(varValues);
		return doCompute(varValues);
	}

	protected abstract BigInteger doCompute(final Map<String, BigInteger> varValues);

	protected abstract void validateState(Map<String, BigInteger> varValues);

}