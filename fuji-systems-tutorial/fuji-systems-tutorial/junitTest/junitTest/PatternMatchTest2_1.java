package junitTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.jupiter.api.Test;

class PatternMatchTest2_1 {

	@Test
	void test() {
		String regex = "Sun";
		Pattern p = Pattern.compile(regex);

		Matcher m1 = p.matcher("Today is Sunday");
		assertTrue(m1.find());

		Matcher m2 = p.matcher("Sunrise");
		assertTrue(m2.find()); // true

		Matcher m3 = p.matcher("Ham Sandwich");
		assertFalse(m3.find()); // false

		// Sとdの間に任意の2文字
		String regex2 = "S..d";
		Pattern p2 = Pattern.compile(regex2);

		Matcher m4 = p2.matcher("Today is Sunday");
		assertTrue(m4.find()); // true

		Matcher m5 = p2.matcher("Sunrise");
		assertFalse(m5.find()); // false

		Matcher m6 = p2.matcher("Ham Sandwich");
		assertTrue(m6.find()); // true

		// 括弧の中身のいずれかの場合
		String regex3 = "[Ss]un";
		Pattern p3 = Pattern.compile(regex3);

		Matcher m7 = p3.matcher("Today is Sunday");
		assertTrue(m7.find()); // true

		Matcher m8 = p3.matcher("sunrise");
		assertTrue(m8.find()); // true

		Matcher m9 = p3.matcher("Ham Sandwich");
		assertFalse(m9.find()); // false

		// 先頭が一致
		String regex4 = "^Red";
		Pattern p4 = Pattern.compile(regex4);

		Matcher m10 = p4.matcher("Red Table");
		assertTrue(m10.find()); // true

		Matcher m11 = p4.matcher("Reduce speed");
		assertTrue(m11.find()); // true

		Matcher m12 = p4.matcher("Border Color is Red");
		assertFalse(m12.find()); // false

		// 末尾が一致
		String regex5 = "Script$";
		Pattern p5 = Pattern.compile(regex5);

		Matcher m13 = p5.matcher("JavaScript");
		assertTrue(m13.find()); // true

		Matcher m14 = p5.matcher("I am studying TypeScript");
		assertTrue(m14.find()); // true

		Matcher m15 = p5.matcher("PostScript is difficult");
		assertFalse(m15.find()); // false

		// 文字列の先頭
		String regex6 = "\\Ache";
		Pattern p6 = Pattern.compile(regex6, Pattern.MULTILINE);

		Matcher m16 = p6.matcher("cheese cake");
		assertTrue(m16.find()); // true

		Matcher m17 = p6.matcher("check out");
		assertTrue(m17.find()); // true

		Matcher m18 = p6.matcher("Apache");
		assertFalse(m18.find()); // false

		// 末尾(行末文字も対象に含む)
		String regex7 = "che\\z";
		Pattern p7 = Pattern.compile(regex7);

		Matcher m19 = p7.matcher("cheese cake");
		assertFalse(m19.find()); // false

		Matcher m20 = p7.matcher("page cache");
		assertTrue(m20.find()); // true

		Matcher m21 = p7.matcher("Apache");
		assertTrue(m21.find()); // true

		Matcher m22 = p7.matcher("Apache\n");
		assertFalse(m22.find()); // false

		// 末尾(行末文字も対象に含まない)
		String regex8 = "ABC\\Z";
		Pattern p8 = Pattern.compile(regex8);

		Matcher m23 = p8.matcher("ABC");
		assertTrue(m23.find()); // true

		Matcher m24 = p8.matcher("ABC\n");
		assertTrue(m24.find()); // true

		// 境界単語
		String regex9 = "\\bwork";
		Pattern p9 = Pattern.compile(regex9);

		Matcher m25 = p9.matcher("a working person");
		assertTrue(m25.find()); // true

		Matcher m26 = p9.matcher("Go to see fireworks");
		assertFalse(m26.find()); // false

		String regex10 = "ing\\b";
		Pattern p10 = Pattern.compile(regex10);

		Matcher m27 = p10.matcher("a working person");
		assertTrue(m27.find()); // true

		Matcher m28 = p10.matcher("ingenious design");
		assertFalse(m28.find()); // false

		String regex11 = "\\Bam";
		Pattern p11 = Pattern.compile(regex11);

		Matcher m29 = p11.matcher("Difficult program");
		assertTrue(m29.find()); // true

		Matcher m30 = p11.matcher("Go to see fireworks");
		assertFalse(m30.find()); // false

		String regex12 = "am\\B";
		Pattern p12 = Pattern.compile(regex12);

		Matcher m31 = p12.matcher("Difficult program");
		assertFalse(m31.find()); // false

		Matcher m32 = p12.matcher("full amount");
		assertTrue(m32.find()); // true

		String regex13 = "AB+";
		Pattern p13 = Pattern.compile(regex13);

		Matcher m33 = p13.matcher("ABBBC");
		if (m33.find()) {
			assertEquals(m33.group(), "ABBB"); // ABBB
		}

		String regex14 = "AB++";
		Pattern p14 = Pattern.compile(regex14);

		Matcher m34 = p14.matcher("ABBBC");
		if (m34.find()) {
			assertEquals(m34.group(), "ABBB"); // ABBB
		}
	}

}
