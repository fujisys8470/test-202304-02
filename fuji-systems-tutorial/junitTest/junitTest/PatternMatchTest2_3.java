package junitTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.jupiter.api.Test;

class PatternMatchTest2_3 {
	@Test
	void test() {
		sample1();
		sample2();
		sample3();
		sample4();
		sample5();
		sample6();
		sample7();
		sample8();
	}

	void sample1() {
		String[] target = { "apple", "Apple", "APPLE" };

		String regex = "apple";
		Pattern p1 = Pattern.compile(regex);

		Matcher m0 = p1.matcher(target[0]);
		Matcher m1 = p1.matcher(target[1]);
		Matcher m2 = p1.matcher(target[2]);
		assertTrue(m0.find());
		assertFalse(m1.find());
		assertFalse(m2.find());

		Pattern p2 = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

		Matcher m2_0 = p2.matcher(target[0]);
		Matcher m2_1 = p2.matcher(target[1]);
		Matcher m2_2 = p2.matcher(target[2]);
		assertTrue(m2_0.find());
		assertTrue(m2_1.find());
		assertTrue(m2_2.find());
	}

	void sample2() {
		String target1 = "apple is red\nlemon is yellow";
		String target2 = "lemon is yellow\napple is red";

		String regex = "^apple";
		Pattern p1 = Pattern.compile(regex);

		Matcher m1_1 = p1.matcher(target1);
		assertTrue(m1_1.find());
		Matcher m1_2 = p1.matcher(target2);
		assertFalse(m1_2.find());

		Pattern p2 = Pattern.compile(regex, Pattern.MULTILINE);

		Matcher m2_1 = p2.matcher(target1);
		assertTrue(m2_1.find());
		Matcher m2_2 = p2.matcher(target2);
		assertTrue(m2_2.find());
	}

	void sample3() {
		String target1 = "apple is red\nlemon is yellow";
		String target2 = "lemon is yellow\napple is red";

		String regex = "yellow$";
		Pattern p1 = Pattern.compile(regex);

		Matcher m1_1 = p1.matcher(target1);
		assertTrue(m1_1.find());
		Matcher m1_2 = p1.matcher(target2);
		assertFalse(m1_2.find());

		Pattern p2 = Pattern.compile(regex, Pattern.MULTILINE);

		Matcher m2_1 = p2.matcher(target1);
		assertTrue(m2_1.find());
		Matcher m2_2 = p2.matcher(target2);
		assertTrue(m2_2.find());
	}

	void sample4() {
		String target1 = "<p>Lemon is yellow.Strawberry is red</p>";
		String target2 = "<p>Lemon is yellow.\nStrawberry is red</p>";

		String regex = "<p>.*</p>";
		Pattern p1 = Pattern.compile(regex);

		Matcher m1_1 = p1.matcher(target1);
		assertTrue(m1_1.find());
		Matcher m1_2 = p1.matcher(target2);
		assertFalse(m1_2.find());

		Pattern p2 = Pattern.compile(regex, Pattern.DOTALL);

		Matcher m2_1 = p2.matcher(target1);
		assertTrue(m2_1.find());
		Matcher m2_2 = p2.matcher(target2);
		assertTrue(m2_2.find());
	}

	void sample5() {
		String target1 = "Thank You!\r\nGood Bye";
		String target2 = "Good Bye\nThank You!";
		String target3 = "Good Bye\r\nThank You!";

		String regex = "Bye$";
		Pattern p1 = Pattern.compile(regex, Pattern.MULTILINE);

		Matcher m1_1 = p1.matcher(target1);
		assertTrue(m1_1.find());
		Matcher m1_2 = p1.matcher(target2);
		assertTrue(m1_2.find());
		Matcher m1_3 = p1.matcher(target3);
		assertTrue(m1_3.find());

		Pattern p2 = Pattern.compile(regex, Pattern.MULTILINE | Pattern.UNIX_LINES);

		Matcher m2_1 = p2.matcher(target1);
		assertTrue(m2_1.find());
		Matcher m2_2 = p2.matcher(target2);
		assertTrue(m2_2.find());
		Matcher m2_3 = p2.matcher(target3);
		assertFalse(m2_3.find());
	}

	void sample6() {
		String target = "AZ-243";
		String regex = "[a-zA-Z]{2}  # 製品名" + //
				"-            # ハイフン" + //
				"[0-9]{3}     # 製品コード";
		Pattern p = Pattern.compile(regex, Pattern.COMMENTS);

		Matcher m = p.matcher(target);
		assertTrue(m.find());
	}

	void sample7() {
		String target1 = "ｂｏｏｋ";
		String target2 = "ＢＯＯＫ";

		String regex = "ｂｏｏｋ";
		Pattern p1 = Pattern.compile(regex);

		Matcher m1_1 = p1.matcher(target1);
		assertTrue(m1_1.find());
		Matcher m1_2 = p1.matcher(target2);
		assertFalse(m1_2.find());

		Pattern p2 = Pattern.compile(regex, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);

		Matcher m2_1 = p2.matcher(target1);
		assertTrue(m2_1.find());
		Matcher m2_2 = p2.matcher(target2);
		assertTrue(m2_2.find());
	}

	void sample8() {
		String target1 = "A1B";
		String target2 = "A240B";
		String target3 = "A[0-9]*B";

		String regex = "A[0-9]*B";
		Pattern p1 = Pattern.compile(regex);

		Matcher m1_1 = p1.matcher(target1);
		assertTrue(m1_1.find());
		Matcher m1_2 = p1.matcher(target2);
		assertTrue(m1_2.find());
		Matcher m1_3 = p1.matcher(target3);
		assertFalse(m1_3.find());

		Pattern p2 = Pattern.compile(regex, Pattern.LITERAL);

		Matcher m2_1 = p2.matcher(target1);
		assertFalse(m2_1.find());
		Matcher m2_2 = p2.matcher(target2);
		assertFalse(m2_2.find());
		Matcher m2_3 = p2.matcher(target3);
		assertFalse(!m2_3.find());
	}
}
