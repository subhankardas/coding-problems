package hackerrank.string_manipulation;

/**
 * A string is said to be a special string if either of two conditions is met:
 * 
 * All of the characters are the same, e.g. aaa. All characters except the
 * middle one are the same, e.g. aadaa. A special substring is any substring of
 * a string which meets one of those criteria. Given a string, determine how
 * many special substrings can be formed from it.
 * 
 */
public class SpecialStringAgain {

	public static void main(String[] args) {

		String s = "abcbaba";
		System.out.println(substrCount(s.length(), s));

	}

	static long substrCount(int n, String s) {
		int len = s.length();
		String str = "";
		int count = 0;

		for (int i = 0; i < len; i++) {
			str = "";
			for (int j = i; j < len; j++) {
				str += s.charAt(j);
				if (isSpecialString(str)) {
					count++;
				}
			}
		}

		return count;
	}

	static boolean isSpecialString(String str) {
		int len = str.length();

		if (len <= 0)
			return false;
		else if (len == 1)
			return true;

		for (int i = 0; i < len / 2; i++) {
			if (str.charAt(i) != str.charAt(0) || str.charAt(len - 1 - i) != str.charAt(0)) {
				return false;
			}
		}

		return true;
	}

}
