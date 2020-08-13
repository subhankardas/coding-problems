package hackerrank.recursion;

public class SuperDigit {

	public static void main(String[] args) {
		String n = "593";
		int k = 10;

		// Solution
		String sum = sumOfDigits(n);
		long num = Long.parseLong(sum) * k;

		int result = calculate(Long.toString(num));
		System.out.println(result);
	}

	public static int calculate(String num) {
		int digits = num.length();
		if (digits == 1) {
			return Integer.parseInt(num);
		} else {
			String sum = sumOfDigits(num);
			return calculate(sum);
		}
	}

	public static String sumOfDigits(String num) {
		long sum = 0;
		for (int idx = 0; idx < num.length(); idx++) {
			sum += Character.getNumericValue(num.charAt(idx));
		}
		return Long.toString(sum);
	}

}
