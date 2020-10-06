package hackerrank.string_manipulation;

public class AlternatingCharacters {

	public static void main(String[] args) {

		String s = "AAABBB";
		System.out.println(alternatingCharacters(s));

	}

	static int alternatingCharacters(String s) {
		int len = s.length();
		char last = 0, curr;
		int deletions = 0;

		// Loop through all the characters for the string
		for (int idx = 0; idx < len; idx++) {
			curr = s.charAt(idx);

			// If last character is same as current, this character needs to be deleted
			if (last == curr) {
				deletions++;
			}

			last = curr;
		}

		return deletions;
	}

}
