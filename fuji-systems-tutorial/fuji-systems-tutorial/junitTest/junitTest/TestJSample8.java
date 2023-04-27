package junitTest;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

import test.JSample8;

class TestJSample8 {

	@Test
	public void 表示結果が同じか() {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));

		// テスト対象メソッド呼び出し
		JSample8.test8_1();
		String expected = joinStrings("85 & 15 = 5\r\n" + "85 | 15 = 95\r\n" + "85 ^ 15 = 90\r\n" + "~85 = -86");
		String actual = out.toString();
		assertEquals(actual, expected);
		JSample8.test8_2();
		String expected2 = joinStrings("85 & 15 = 5\r\n" //
				+ "85 | 15 = 95\r\n" //
				+ "85 ^ 15 = 90\r\n" //
				+ "~85 = -86\r\n" //
				+ "21 << 2 = 84\r\n"//
				+ "21 >> 2 = 5\r\n" //
				+ "21 >>> 2 = 5\r\n" //
				+ "-92 >> 2 = -23\r\n" //
				+ "-92 >>> 2 = 1073741801");
		String actual2 = out.toString();
		assertEquals(actual2, expected2);
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
