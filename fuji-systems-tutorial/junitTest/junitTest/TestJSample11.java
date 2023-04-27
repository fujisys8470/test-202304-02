package junitTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

class TestJSample11 {

	@Test
	void test() {
		int a = 4;
		int b = 7;
		assertFalse(gt(a, b));
		assertTrue(gt(b, a));
		assertFalse(a >= b);
		assertTrue(a < b);
		assertTrue(a <= b);
		assertFalse(a == b);
		assertTrue(a != b);
		int[] ar = { 85, 78, 92 };
		int[] br = { 85, 78, 92 };
		int[] cr = ar;
		assertFalse(ar == br);
		assertTrue(ar == cr);
	}

	public boolean gt(int a, int b) {
		return a > b;
	}
}
