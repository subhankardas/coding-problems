package hackerrank.project_euler;

// Project Euler #4: Largest palindrome product
// https://www.hackerrank.com/contests/projecteuler/challenges/euler004/problem
public class ProjectEuler_4_LargestPalindromeProduct {

    public static void main(String[] args) {
        System.out.println(largestPalindromeLessThanN(800000));
        System.out.println(largestPalindromeLessThanN(101110));
    }

    // Check if num is a palindrome.
    public static boolean isPalindrome(int num) {
        int original = num;
        int reverse = 0;

        while (num > 0) {
            int digit = num % 10;
            reverse = reverse * 10 + digit;
            num /= 10;
        }

        return original == reverse;
    }

    public static int largestPalindromeLessThanN(int limit) {
        for (int num = limit - 1; num > 100000; num--) {
            if (isPalindrome(num)) { // Check if i is a palindrome
                for (int q = 999; q >= 100; q--) {

                    if (num % q == 0) { // Check if num can be factorized into two 3-digit numbers
                        int quotient = num / q;
                        if (quotient >= 100 && quotient <= 999) {
                            return num;
                        }
                    }
                }
            }
        }
        return -1;
    }

}
