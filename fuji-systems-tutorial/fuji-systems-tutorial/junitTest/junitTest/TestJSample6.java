package junitTest;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import test.JSample6;

class TestJSample6 {

	@Test
	void test() {
		int testNum = 0;
		testNum = JSample6.test6_1(1);
		assertEquals(testNum, 1);
	}

}
