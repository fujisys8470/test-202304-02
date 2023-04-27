package junitTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

class TestJSample12 {

	@Test
	void test() {
		int a = 7;
		int b = 4;
		assertFalse(a < 0 && b > 5);
		assertFalse(a < 5 && b > 3);
		assertFalse(a < 9 && b > 7);
		assertTrue(a < 9 && b > 3);

		assertFalse(a < 0 || b > 5);
		assertTrue(a < 5 || b > 3);
		assertTrue(a < 9 || b > 7);
		assertTrue(a < 9 || b > 3);

		assertFalse(!(a > 0));
		assertTrue(!(a > 9));
	}

}
