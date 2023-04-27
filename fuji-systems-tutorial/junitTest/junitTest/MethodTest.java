package junitTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import test.MethodSample;

class MethodTest {

	@Test
	public void test() {
		int testNum = 0;
		int[] numList = { 0, 1, 2, 3 };
		int[] numListTest;
		assertEquals(testNum, 0);
		add(testNum, 10);// 計算結果が戻り値でありどこにも代入されない
		assertEquals(testNum, 0);
		testNum = add(testNum, 10);
		assertEquals(testNum, 10);
		addDirect(testNum, 10);// testNumがローカル変数なので変化しない
		assertEquals(testNum, 10);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));

		// テスト対象メソッド呼び出し
		MethodSample.main(new String[0]);
		String expected = "724";
		String actual = out.toString();
		assertEquals(actual, expected);

		numListTest = init();
		assertTrue(Arrays.equals(numList, numListTest));

		int testNum2 = add(1, 2, 3);
		assertEquals(testNum2, 6);
	}

	private int add(int a, int b) {
		return a + b;
	}

	// addのオーバーロード
	private int add(int a, int b, int c) {
		return a + b + c;
	}

	private void addDirect(int a, int b) {
		a = a + b;
	}

	private static int[] init() {
		int data[] = new int[4];
		for (int i = 0; i < 4; i++) {
			data[i] = i;
		}
		return data;
	}
}
