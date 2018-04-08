package com.synopsys.expr.calc;

import static org.junit.Assert.assertArrayEquals;

import java.math.BigInteger;

import org.junit.Test;

public class ExprCalcMainIT {

	@Test
	public void happyPath() {
		final String[] expressions = new String[] {
				//@formatter:off
				"let(a, let(b, 10, add(b, b)), let(b, 20, add(a, b))",
				"mult(5, sub(1,3))",
				"add(1, mult(2, 3))",
				"mult(add(2, 2), div(9, 3))",
				"let(a, 5, let(b, mult(a, 10), add(b, a)))",
				"let(a, 5, add(a, a))"
				//@formatter:on
		};
		final Object[] actualResults = ExprCalcMain.evaluate(expressions);
		final Object[] expectedResults = new Object[] {
				//@formatter:off
				BigInteger.valueOf(40),
				BigInteger.valueOf(-10),
				BigInteger.valueOf(7),
				BigInteger.valueOf(12),
				BigInteger.valueOf(55),
				BigInteger.valueOf(10)
				//@formatter:off
				};
		assertArrayEquals(expectedResults, actualResults);
	}
}