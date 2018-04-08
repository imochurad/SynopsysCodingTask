package com.synopsys.expr.calc.tree.nodes;

import com.synopsys.expr.calc.tree.TreeNode;

public abstract class OperandNode extends TreeNode {

	@Override
	public boolean isLeafNode() {
		return true;
	}

}