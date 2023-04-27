package junitTest;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

import test.JSample4_2;

class TestJSample4_2 {

	@Test
	public void 表示結果が同じか() {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));

		// テスト対象メソッド呼び出し
		JSample4_2.main(new String[0]);
		String expected = joinStrings("10 - 5 - 3 = 2");
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
