package test;

public class StringTest {

	public static void main(String[] args) {
		String str1 = "東京都港区";
		String str2 = "東京都港市";

		System.out.println(str1.compareTo(str2));
		System.out.println(str1.charAt(4) + ":" + Integer.toString(str1.charAt(4)));
		System.out.println(str2.charAt(4) + ":" + Integer.toString(str2.charAt(4)));
		int num = Integer.parseInt(Integer.toString(str1.charAt(4)))
				- Integer.parseInt(Integer.toString(str2.charAt(4)));
		System.out.println(Integer.toString(str1.charAt(4)) + "+" + Integer.toString(str2.charAt(4)) + "=" + num);

		String msg = "  AB CD ";
		System.out.println("[" + msg + "]");
		System.out.println("[" + msg.trim() + "]"); // [AB CD]
		System.out.println("[" + msg.strip() + "]"); // [AB CD]
		System.out.println("[" + msg.stripLeading() + "]");
		System.out.println("[" + msg.stripTrailing() + "]");
		System.out.println("[" + msg.strip().toLowerCase() + "]");
	}

}
