package junitTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;

import org.junit.jupiter.api.Test;

class RoopTest {

	@Test
	void test() {
		int num = 0;
		Random rand = new Random();
		for (int i = 1; i <= 5; i++) {
			num += i;
		}
		assertEquals(num, 15);

		while (num > 0) {
			num--;
		}
		assertEquals(num, 0);

		do {
			num = rand.nextInt(6) + 1;
		} while (num != 6);

		assertTrue(num == 6);

		do {
			num -= 2;

			if (num < 0) {
				break;
			}
		} while (true);
		assertTrue(num < 0);

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));

		// テスト対象メソッド呼び出し
		String pref[] = { "北海道", "東京都", "神奈川県" };
		for (String str : pref) {
			System.out.println(str);
		}
		String expected = joinStrings("北海道\r\n" + "東京都\r\n" + "神奈川県");
		String actual = out.toString();
		assertEquals(actual, expected);

		int cntOuter = 0;
		Outer: for (int i = 1; i < 9; i++) {
			for (int j = 1; j < 9; j++) {
				System.out.println("i * j = " + i * j);
				cntOuter = i * j;
				if (cntOuter > 10) {
					break Outer;
				}
			}
		}
		assertEquals(cntOuter, 12);

		int cntCont = 0;
		for (int i = 1; i < 7; i++) {
			if (cntCont == 10) {
				continue;
			}
			cntCont = cntCont + i;
		}
		assertTrue(cntCont == 10);

		int cntOuterCont = 0;
		Outer: for (int i = 1; i < 6; i++) {
			Inner: for (int j = 1; j < 6; j++) {
				if (i * j % 4 == 0) {
					cntOuterCont = i * j;
					continue Outer;
				}
			}
		}
		assertTrue(cntOuterCont % 4 == 0);
		System.out.println("End");
	}

	private String joinStrings(String... strs) {
		String newLine = System.getProperty("line.separator");
		String result = "";
		for (String s : strs) {
			result += s + newLine;
		}
		return result;
	}

}
