package junitTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.jupiter.api.Test;

class PatternMatchTest2_2 {

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
		sample9();
		sample10();
		sample11();
		sample12();
		sample13();
		sample14();
		sample15();
		sample16();
		sample17();
		sample18();
		sample19();
		sample20();
	}

	void sample1() {
		String regex = "Ha*n";
		Pattern p = Pattern.compile(regex);

		Matcher m1 = p.matcher("Hn");
		assertTrue(m1.find()); // true

		Matcher m2 = p.matcher("Han");
		assertTrue(m2.find()); // true

		Matcher m3 = p.matcher("Haaaaaan");
		assertTrue(m3.find()); // true

		Matcher m4 = p.matcher("HaaYaan");
		assertFalse(m4.find()); // false
	}

	void sample2() {
		String regex = "Ha+n";
		Pattern p = Pattern.compile(regex);

		Matcher m1 = p.matcher("Hn");
		assertFalse(m1.find()); // false

		Matcher m2 = p.matcher("Han");
		assertTrue(m2.find()); // true

		Matcher m3 = p.matcher("Haaaaaan");
		assertTrue(m3.find()); // true

		Matcher m4 = p.matcher("HaaYaan");
		assertFalse(m4.find()); // false
	}

	void sample3() {
		String regex = "Ha?n";
		Pattern p = Pattern.compile(regex);

		Matcher m1 = p.matcher("Hn");
		assertTrue(m1.find()); // true

		Matcher m2 = p.matcher("Han");
		assertTrue(m2.find()); // true

		Matcher m3 = p.matcher("Haaaaaan");
		assertFalse(m3.find()); // false

		Matcher m4 = p.matcher("Hon");
		assertFalse(m4.find()); // false
	}

	void sample4() {
		String regex = "Ha{2}n";
		Pattern p = Pattern.compile(regex);

		Matcher m1 = p.matcher("Hn");
		assertFalse(m1.find()); // false

		Matcher m2 = p.matcher("Han");
		assertFalse(m2.find()); // false

		Matcher m3 = p.matcher("Haan");
		assertTrue(m3.find()); // true

		Matcher m4 = p.matcher("Haaan");
		assertFalse(m4.find()); // false
	}

	void sample5() {
		String regex = "Ha{2,3}n";
		Pattern p = Pattern.compile(regex);

		Matcher m1 = p.matcher("Hn");
		assertFalse(m1.find()); // false

		Matcher m2 = p.matcher("Han");
		assertFalse(m2.find()); // false

		Matcher m3 = p.matcher("Haan");
		assertTrue(m3.find()); // true

		Matcher m4 = p.matcher("Haaan");
		assertTrue(m4.find()); // true

		Matcher m5 = p.matcher("Haaaan");
		assertFalse(m5.find()); // false
	}

	void sample6() {
		String regex1 = "<em>.*</em>";
		Pattern p1 = Pattern.compile(regex1);

		Matcher m1 = p1.matcher("<p>今日は<em>快晴の</em>一日です</p>");
		if (m1.find()) {
			assertEquals(m1.group(), "<em>快晴の</em>"); // <em>快晴の</em>
		}

		String regex2 = "[0-9]{3}-[0-9]{4}";
		Pattern p2 = Pattern.compile(regex2);

		Matcher m2 = p2.matcher("郵便番号は〒123-4567です");
		if (m2.find()) {
			assertEquals(m2.group(), "123-4567"); // 123-4567
		}
	}

	void sample7() {
		String regex = "([0-9]{1,3}\\.){3}[0-9]{1,3}";
		Pattern p = Pattern.compile(regex);

		Matcher m = p.matcher("IPアドレスは192.168.0.18です");
		Matcher m2 = p.matcher("123456789987.654.92.81です");
		if (m.find()) {
			assertEquals(m.group(), "192.168.0.18"); // 192.168.0.18
		}
		if (m2.find()) {
			assertEquals(m2.group(), "987.654.92.81"); // 987.654.9.81
		}
	}

	void sample8() {
		String regex = "blue|Blue";// どちらかがあれば
		Pattern p = Pattern.compile(regex);

		Matcher m1 = p.matcher("My favorite color is blue");
		assertTrue(m1.find()); // true

		Matcher m2 = p.matcher("bluebird weather");
		assertTrue(m2.find()); // true

		Matcher m3 = p.matcher("Cobalt BLUE");
		assertFalse(m3.find()); // false
	}

	void sample9() {
		String regex = "<[0-3]{3}>|<[0-7]{4}>";
		Pattern p = Pattern.compile(regex);

		Matcher m1 = p.matcher("<012>");
		assertTrue(m1.find());

		Matcher m2 = p.matcher("<0246>");
		assertTrue(m2.find());
	}

	void sample10() {
		String regex = "(\\d{3})-(\\d{4})";
		Pattern p = Pattern.compile(regex);

		Matcher m = p.matcher("〒123-4567");
		if (m.find()) {
			assertEquals(m.group(), "123-4567"); // 123-4567
			assertEquals(m.group(0), "123-4567"); // 123-4567
			assertEquals(m.group(1), "123"); // 123
			assertEquals(m.group(2), "4567"); // 4567
		}
	}

	void sample11() {
		String regex = "(\\d{3})-(\\d{4})";
		Pattern p = Pattern.compile(regex);

		Matcher m = p.matcher("〒123-4567");
		if (m.find()) {
			assertEquals(m.group(1), "123"); // 123
			assertEquals(m.start(1), 1); // 1
			assertEquals(m.end(1), 4); // 4
			assertEquals(m.group(2), "4567"); // 4567
			assertEquals(m.start(2), 5); // 5
			assertEquals(m.end(2), 9); // 9
		}
	}

	void sample12() {
		String regex = "((\\d{3})-(\\d{4}))";
		Pattern p = Pattern.compile(regex);

		Matcher m = p.matcher("〒123-4567");
		if (m.find()) {
			assertEquals(m.groupCount(), 3); // 3

			assertEquals(m.group(0), "123-4567"); // 123-4567
			assertEquals(m.group(1), "123-4567"); // 123-4567
			assertEquals(m.group(2), "123"); // 123
			assertEquals(m.group(3), "4567"); // 45670
		}
	}

	void sample13() {
		String regex = "製品(?:Code|コード):([A-Z]{2})-(\\d{2})";
		Pattern p = Pattern.compile(regex);

		Matcher m = p.matcher("製品コード:AZ-07");
		if (m.find()) {
			assertEquals(m.groupCount(), 2); // 2
			assertEquals(m.group(1), "AZ"); // AZ
			assertEquals(m.group(2), "07"); // 07
		}
	}

	void sample14() {
		String regex = "<(.+)>(.*)</\\1>";
		Pattern p = Pattern.compile(regex);

		Matcher m = p.matcher("AAA<div>BBB<span>CCC</span>DDD</div>EEE");
		if (m.find()) {
			assertEquals(m.group(2), "BBB<span>CCC</span>DDD");
		}
	}

	void sample15() {
		String regex = "(?<year>[0-9]{4})/(?<month>[0-9]{2})";
		Pattern p = Pattern.compile(regex);

		Matcher m = p.matcher("1992/10");
		if (m.find()) {
			assertEquals(m.group(), "1992/10");
			assertEquals(m.group("year"), "1992"); // 1992
			assertEquals(m.group("month"), "10"); // 10
			assertEquals(m.start("year"), 0);
			assertEquals(m.end("year"), 4);
		}
	}

	void sample16() {
		String regex = "(?<pref>^.*(?:都|道|府|県))(?<ward>.*区)";
		Pattern p = Pattern.compile(regex);

		Matcher m = p.matcher("東京都港区赤坂");
		if (m.find()) {
			assertEquals(m.group(), "東京都港区");
			assertEquals(m.group("pref"), "東京都");
			assertEquals(m.group("ward"), "港区");
		}
	}

	void sample17() {
		String regex = "(?<pref>^.*(?:都|道|府|県))(?<ward>.*区)";
		Pattern p = Pattern.compile(regex);

		Matcher m = p.matcher("東京都港区赤坂");
		if (m.find()) {
			assertEquals(m.group(), "東京都港区");
			assertEquals(m.group("pref"), "東京都");
			assertEquals(m.start("pref"), 0);
			assertEquals(m.end("pref"), 3);
			assertEquals(m.group("ward"), "港区");
			assertEquals(m.start("ward"), 3);
			assertEquals(m.end("ward"), 5);
		}
	}

	void sample18() {
		String regex = "<(?<tag>.+)>(.*)</\\k<tag>>";
		Pattern p = Pattern.compile(regex);

		Matcher m = p.matcher("AAA<div>BBB<span>CCC</span>DDD</div>EEE");
		if (m.find()) {
			assertEquals(m.group(2), "BBB<span>CCC</span>DDD"); // BBB<span>CCC</span>DDD
		}
	}

	void sample19() {
		String regex = "smart(?=phone)";
		String regex2 = "smart(?!phone)";
		Pattern p = Pattern.compile(regex);
		Pattern p2 = Pattern.compile(regex2);

		String[] target = { "smart", "smartphone", "smartwatch" };
		assertFalse(p.matcher(target[0]).find());// smart
		assertTrue(p.matcher(target[1]).find());// smartphone
		assertFalse(p.matcher(target[2]).find());// smartwatch
		Matcher m = p.matcher(target[1]);
		if (m.find()) {
			assertEquals(m.group(), "smart");
		}
		Matcher m2 = p2.matcher(target[0]);
		Matcher m22 = p2.matcher(target[2]);
		assertTrue(p2.matcher(target[0]).find());// smart
		assertFalse(p2.matcher(target[1]).find());// smartphone
		assertTrue(p2.matcher(target[2]).find());// smartwatch
		if (m2.find()) {
			assertEquals(m2.group(), "smart");
		}
		if (m22.find()) {
			assertEquals(m22.group(), "smart");
		}
	}

	void sample20() {
		String regex = "(?<=digital)camera";
		String regex2 = "(?<!digital)camera";
		Pattern p = Pattern.compile(regex);
		Pattern p2 = Pattern.compile(regex2);

		String[] target = { "camera", "digitalcamera", "analogcamera" };

		Matcher m = p.matcher(target[0]);
		Matcher m1 = p.matcher(target[1]);
		Matcher m2 = p.matcher(target[2]);
		Matcher m20 = p2.matcher(target[0]);
		Matcher m21 = p2.matcher(target[1]);
		Matcher m22 = p2.matcher(target[2]);
		assertFalse(m.find());// camera
		assertTrue(m1.find());// digitalcamera
		assertFalse(m2.find());// analogcamera
		assertTrue(m20.find());// camera
		assertFalse(m21.find());// digitalcamera
		assertTrue(m22.find());// smartanalogcamerawatch
	}
}
