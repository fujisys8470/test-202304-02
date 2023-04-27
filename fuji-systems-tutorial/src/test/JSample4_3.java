package test;

public class JSample4_3 {
	public static void main(String[] args) {
		int n1 = 10 + 8 / 2 * 4;
		int n2 = (10 + 8 / 2) * 4;
		int n3 = ((10 + 8) / 2) * 4;

		System.out.println("10 + 8 / 2 * 4 = " + n1);
		System.out.println("(10 + 8 / 2) * 4 = " + n2);
		System.out.println("((10 + 8) / 2) * 4 = " + n3);
	}
}
