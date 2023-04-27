package junitTest;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

import test.JSample1_1;

class TestJSample1_1 {

	@Test
	public void 表示結果が同じか() {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));

		// テスト対象メソッド呼び出し
		JSample1_1.main(new String[0]);
		String expected = joinStrings("10 + 4 = 14\r\n" + "9 - 2 = 7\r\n" + "3 * 8 = 24\r\n" + "7 / 3 = 2\r\n"
				+ "7 % 3 = 1\r\n" + "10.1 + 4.3 = 14.399999999999999\r\n" + "9.4 - 2.8 = 6.6000000000000005\r\n"
				+ "3.3 * 8.1 = 26.729999999999997\r\n" + "11.4 / 3.5 = 3.257142857142857\r\n"
				+ "11.4 % 3.5 = 0.9000000000000004");
		String actual = out.toString();
		assertEquals(actual, expected);
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
