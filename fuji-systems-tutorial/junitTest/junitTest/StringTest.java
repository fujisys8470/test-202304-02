package junitTest;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class StringTest {

	@Test
	void test() {
		String testString = "BBreakSystems";
		String testString2 = "東京都品川区";
		assertEquals(testString.lastIndexOf('s'), 12);
		assertEquals(testString2.lastIndexOf("大阪府"), -1);
		assertEquals(testString2.lastIndexOf("東京都"), 0);

		String regex = ";|:";
		String str = "赤色:青色;黄色:;";

		String[] result = str.split(regex, 0);
		String[] splitResult = { "赤色", "青色", "黄色" };

		assertTrue(Arrays.deepEquals(result, splitResult));
	}

}
