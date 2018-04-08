package com.synopsys.expr.calc.tree;

import java.math.BigInteger;
import java.util.Iterator;

import com.synopsys.expr.calc.tokenizer.Token;
import com.synopsys.expr.calc.tree.nodes.AddNode;
import com.synopsys.expr.calc.tree.nodes.BinaryOperatorNode;
import com.synopsys.expr.calc.tree.nodes.DivNode;
import com.synopsys.expr.calc.tree.nodes.LetNode;
import com.synopsys.expr.calc.tree.nodes.MultNode;
import com.synopsys.expr.calc.tree.nodes.SubNode;
import com.synopsys.expr.calc.tree.nodes.ValueNode;
import com.synopsys.expr.calc.tree.nodes.VariableNode;

public class TreeBuilder {

	private final Iterable<Token> tokens;

	public TreeBuilder(final Iterable<Token> tokens) {
		this.tokens = tokens;
	}

	public TreeNode build() {
		final Iterator<Token> iter = tokens.iterator();
		return build(iter);
	}

	private TreeNode build(final Iterator<Token> iter) {
		final TreeNode node = getNodeByToken(iter.next());
		if (node instanceof BinaryOperatorNode) {
			node.getChildren().add(build(iter));
			node.getChildren().add(build(iter));
		} else if (node instanceof LetNode) {
			node.getChildren().add(build(iter));
			node.getChildren().add(build(iter));
			node.getChildren().add(build(iter));
		}
		return node;
	}

	private TreeNode getNodeByToken(final Token token) {
		switch (token.getTokenType()) {
		case VALUE:
			return new ValueNode(new BigInteger(token.getData()));
		case VARIABLE:
			return new VariableNode(token.getData());
		case ADD:
			return new AddNode();
		case SUB:
			return new SubNode();
		case MULT:
			return new MultNode();
		case DIV:
			return new DivNode();
		case LET:
			return new LetNode();
		default:
			return null;
		}

	}

}