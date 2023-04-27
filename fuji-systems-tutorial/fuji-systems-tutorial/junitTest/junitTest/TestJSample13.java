package junitTest;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class TestJSample13 {

	@Test
	void test() {
		int score;

		score = 70;
		assertFalse(scoreTest(score));

		score = 84;
		assertTrue(scoreTest(score));
	}

	public boolean scoreTest(int score) {
		return score > 70 ? true : false;
	}

}
