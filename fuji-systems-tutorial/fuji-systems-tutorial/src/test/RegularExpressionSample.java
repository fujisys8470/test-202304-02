package test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionSample {
	public static List<Boolean> result = new ArrayList<Boolean>();

	public static void main(String[] args) {
		Pattern p1 = patternCompileMethod("g..d");// 何でもいい2文字
		Pattern p2 = patternCompileMethod("g.*d");// 何でもいい文字の連続
		result.add(matchesMethod(p1, "good"));
		result.add(matchesMethod(p2, "gd"));
		result.add(matchesMethod(p2, "gabcd"));
		result.add(matchesMethod(p2, "gabddc"));
	}

	public static boolean matchesMethod(Pattern p, String target) {
		Matcher m = p.matcher(target);
		return m.matches();
	}

	public static Pattern patternCompileMethod(String target) {
		return Pattern.compile(target);
	}

	public static List<Boolean> getResult() {
		return result;
	}

}
