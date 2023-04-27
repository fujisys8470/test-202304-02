package junitTest;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

import test.JSample10;

class TestJSample10 {

	@Test
	public void 表示結果が同じか() {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));

		int p, m;

		// テスト対象メソッド呼び出し
		p = JSample10.plus(5);
		assertEquals(p, 10);
		m = JSample10.multiplication(5);
		assertEquals(m, 20);
		JSample10.multiplAssignment();
		String expected = joinStrings("15\r\n" + "15\r\n" + "15");
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