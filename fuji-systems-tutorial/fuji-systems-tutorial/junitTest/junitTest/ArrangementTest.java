package junitTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.Arrays;
import java.util.Random;

import org.junit.jupiter.api.Test;

class ArrangementTest {

	@Test
	void test() {
		int[] num = new int[3];
		String[] str = { "Apple", "Orange", "Melon" };
		Random random = new Random();
		for (int i = 0; i < 3; i++) {
			num[i] = random.nextInt();
		}

		assertEquals(num.length, 3);
		assertEquals(str.length, 3);
		assertEquals(str[2], "Melon");

		int[][] num2 = new int[2][];

		num2[0] = new int[3];
		num2[0][0] = 78;
		num2[0][1] = 64;
		num2[0][2] = 59;

		num2[1] = new int[4];
		num2[1][0] = 58;
		num2[1][1] = 92;
		num2[1][2] = 82;

		assertEquals(num2[0].length, 3);
		assertEquals(num2[1].length, 4);
		assertEquals(num2[0][0], 78);

		int[] num3 = new int[3];
		Arrays.fill(num3, 10);

		assertEquals(num3[random.nextInt(3)], 10);

		// shallow copy
		MyTest[] srcShallow = { new MyTest(28), new MyTest(12) };
		MyTest[] dstShallow = new MyTest[2];

		for (int i = 0; i < srcShallow.length; i++) {
			dstShallow[i] = srcShallow[i];
		}
		assertEquals(srcShallow[0].num, dstShallow[0].num);
		srcShallow[0].num = 41;
		assertEquals(dstShallow[0].num, 41);

		// deep copy
		MyTest[] srcDeep = { new MyTest(28), new MyTest(12) };
		MyTest[] dstDeep = new MyTest[2];

		for (int i = 0; i < srcDeep.length; i++) {
			dstDeep[i] = new MyTest(srcDeep[i].num);
		}

		assertEquals(srcDeep[0].num, dstDeep[0].num);

		srcDeep[0].num = 41;

		assertNotEquals(srcDeep[0].num, dstDeep[0].num);

		int[] src = { 12, 24, 18, 35, 21 };
		int[] dst = Arrays.copyOfRange(src, 1, 4);
		int[] dst2 = Arrays.copyOf(src, 1);

		assertEquals(dst.length, 4 - 1);
		assertEquals(dst2.length, 1);

		int[] src1 = { 28, 14, 35, 19 };
		int[] src2 = { 17, 40, 23 };

		int[] dstS = new int[src1.length + src2.length];

		assertEquals(dstS.length, 7);

		int[] srcSort = { 12, 24, 18, 35, 21 };
		Arrays.sort(srcSort);
		assertEquals(srcSort[0], 12);
	}
}

class MyTest {
	public int num;

	public MyTest(int n) {
		num = n;
	}
}
