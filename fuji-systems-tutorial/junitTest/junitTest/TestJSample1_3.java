package junitTest;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

import test.JSample1_3;

class TestJSample1_3 {

	@Test
	public void 表示結果が同じか() {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));

		// テスト対象メソッド呼び出し
		JSample1_3.main(new String[0]);
		String expected = joinStrings("Infinity\r\n" + "NaN");
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
