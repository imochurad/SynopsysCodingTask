package com.synopsys.expr.calc.tree;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class TreeNode {

	protected List<TreeNode> children;

	public List<TreeNode> getChildren() {
		return children;
	}

	public abstract String getData();

	public abstract boolean isLeafNode();

	public abstract BigInteger compute(Map<String, BigInteger> varValues);

	public BigInteger compute() {
		return compute(new HashMap<>());
	}

}