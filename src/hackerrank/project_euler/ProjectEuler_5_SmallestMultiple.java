package hackerrank.project_euler;

// Project Euler #5: Smallest multiple
// https://www.hackerrank.com/contests/projecteuler/challenges/euler005/problem
public class ProjectEuler_5_SmallestMultiple {

    public static void main(String[] args) {
        System.out.println(solution(20));
    }

    // Smallest multiple of all numbers from 1 to N is the LCM of all numbers.
    public static int solution(int n) {
        int res=1;
        for (int i = 2; i <= n; i++) {
            res = lcm(res, i);
        }
        return res;
    }

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

}
