package test;

public class JSample8 {

	public static void main(String[] args) {
		test8_1();
		test8_2();
	}

	public static void test8_1() {
		int test8_1_1 = 85 & 15;
		int test8_1_2 = 85 | 15;
		int test8_1_3 = 85 ^ 15;
		int test8_1_4 = ~85;

		System.out.println("85 & 15 = " + test8_1_1);
		System.out.println("85 | 15 = " + test8_1_2);
		System.out.println("85 ^ 15 = " + test8_1_3);
		System.out.println("~85 = " + test8_1_4);
	}

	public static void test8_2() {
		int i1 = 21 << 2;
		int i2 = 21 >> 2;
		int i3 = 21 >>> 2;

		System.out.println("21 << 2 = " + i1);
		System.out.println("21 >> 2 = " + i2);
		System.out.println("21 >>> 2 = " + i3);

		int i4 = -92 >> 2;
		int i5 = -92 >>> 2;

		System.out.println("-92 >> 2 = " + i4);
		System.out.println("-92 >>> 2 = " + i5);
	}
}
