package com.synopsys.expr.calc.tree.nodes;

import java.util.ArrayList;

import com.synopsys.expr.calc.tree.TreeNode;

public abstract class OperatorNode extends TreeNode {

	public OperatorNode() {
		super.children = new ArrayList<>();
	}

	@Override
	public boolean isLeafNode() {
		return false;
	}

}