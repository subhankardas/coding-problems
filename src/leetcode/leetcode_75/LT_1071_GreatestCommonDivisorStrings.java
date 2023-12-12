package leetcode.leetcode_75;

/**
 * Problem : For two strings s and t, we say "t divides s" if and only if
 * s = t + ... + t (i.e., t is concatenated with itself one or more times).
 * 
 * Given two strings str1 and str2, return the largest string x such that x
 * divides both str1 and str2.
 * 
 * Level : EASY
 * Runtime: 1 ms Beats 84.00% of users with Java.
 * Memory : 41.50 MB Beats 25.06% of users with Java.
 * 
 * @author Subhankar Das
 */
public class LT_1071_GreatestCommonDivisorStrings {

    public static void main(String[] args) {
        System.out.println(gcdOfStrings("ABABAB", "ABAB"));
        System.out.println(gcdOfStrings("LEET", "CODE"));
    }

    public static String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) { // Strings does not have common repeating prefix/divisor
            return "";
        }
        return str1.substring(0, gcd(str1.length(), str2.length())); // Substring of common prefix of
        // length equal to GCD of two strings.
        // e.g. ABABABAB + ABAB -> GCD = 2 -> ABABAB/ABAB =>substring(0, GCD) = result
    }

    public static int gcd(int a, int b) { // Calculate GCD of two numbers
        return b == 0 ? a : gcd(b, a % b);
    }

}
