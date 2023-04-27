package junitTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

class ExceptionTest {

	@Test
	void test() {
		int[] num = new int[3];
		int cnt = 0;
		boolean exp = false;
		for (int i = 0; i < 4; i++) {
			try {
				System.out.println(num[i]);
			} catch (ArrayIndexOutOfBoundsException e) {
				exp = true;
				cnt++;
			} finally {
				exp = true;
				cnt++;
			}
		}
		assertEquals(cnt, 5);
		assertTrue(exp);
	}

}
