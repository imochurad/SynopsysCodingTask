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

	@Test
	public void justValue() {
		final String[] expressions = new String[] {
				"100"
		};
		final Object[] actualResults = ExprCalcMain.evaluate(expressions);
		final Object[] expectedResults = new Object[] {
				BigInteger.valueOf(100)
		};
		assertArrayEquals(expectedResults, actualResults);
	}

	@Test
	public void divizionByZero() {
		final String[] expressions = new String[] {
				"div(100,0)"
		};
		final Object[] actualResults = ExprCalcMain.evaluate(expressions);
		final Object[] expectedResults = new Object[] {
				"BigInteger divide by zero"
		};
		assertArrayEquals(expectedResults, actualResults);
	}

	@Test
	public void badInput() {
		final String[] expressions = new String[] {
				"div(1000)"
		};
		final Object[] actualResults = ExprCalcMain.evaluate(expressions);
		final Object[] expectedResults = new Object[] {
				"Unable to create BinaryOperatorNode, 2 args required!"
		};
		assertArrayEquals(expectedResults, actualResults);
	}

	@Test
	public void multiplicationOf2Integers_noOverflow() {
		final String[] expressions = new String[] {
				"mult(" + Integer.MAX_VALUE + "," + Integer.MAX_VALUE + ")"
		};
		final Object[] actualResults = ExprCalcMain.evaluate(expressions);
		final Object[] expectedResults = new Object[] {
				new BigInteger("4611686014132420609")
		};
		assertArrayEquals(expectedResults, actualResults);
	}

}