package test;

public class JUnitSample {
	static int a = 9;
	static int b = 8;

	public static void main(String[] args) {
		System.out.println(calculation(a, b));
	}

	public static int calculation(int a, int b) {
		return a + b;
	}
}
