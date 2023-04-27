package test;

public class JSample10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		multiplAssignment();
	}

	public static int plus(int num) {
		num += 5;
		return num;
	}

	public static int multiplication(int num) {
		num *= 4;
		return num;
	}

	public static void multiplAssignment() {
		int a, b, c;
		a = b = c = 15;
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
	}

}
