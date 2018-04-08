package com.synopsys.expr.calc.di;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.synopsys.expr.calc.ExpressionCalculator;
import com.synopsys.expr.calc.tokenizer.Tokenizer;
import com.synopsys.expr.calc.tokenizer.impl.TokenizerImpl;
import com.synopsys.expr.calc.tree.TreeExpressionCalculator;

public class ExprCalcModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(ExpressionCalculator.class).to(TreeExpressionCalculator.class);
	}

	@Provides
	public Tokenizer configureTokenizer() {
		return new TokenizerImpl(",|\\(|\\)");
	}

}