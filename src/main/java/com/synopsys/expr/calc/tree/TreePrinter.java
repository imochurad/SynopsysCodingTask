package com.synopsys.expr.calc.tree;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TreePrinter {

	private static final Logger LOG = LoggerFactory.getLogger(TreePrinter.class);

	public void print(final TreeNode root) {
		final StringBuilder sb = new StringBuilder();
		appendToStringBuilder(root, "\n", sb, true);
		LOG.debug("Tree representation of expression:{}", sb.toString());
	}

	private void appendToStringBuilder(final TreeNode node, final String prefix, final StringBuilder sb,
			final boolean isTail) {
		sb.append(prefix + (isTail ? "└── " : "├── ") + node.getData());
		if (!node.isLeafNode()) {
			for (int i = 0; i < node.getChildren().size() - 1; i++) {
				appendToStringBuilder(node.getChildren().get(i), prefix + (isTail ? "    " : "│   "), sb, false);
			}
			if (node.getChildren().size() > 0) {
				appendToStringBuilder(node.children.get(node.children.size() - 1), prefix + (isTail ? "    " : "│   "),
						sb, true);
			}
		}
	}

}