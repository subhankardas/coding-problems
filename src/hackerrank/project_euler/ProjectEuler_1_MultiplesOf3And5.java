package hackerrank.project_euler;

/**
 * Problem: If we list all the natural numbers below that are multiples of or ,
 * we get and . The sum of these multiples is .
 * 
 * Find the sum of all the multiples of or below .
 */
public class ProjectEuler_1_MultiplesOf3And5 {

    public static void main(String[] args) {
        System.out.println(solution1(10));
        System.out.println(solution1(100));

        System.out.println(solution(10));
        System.out.println(solution(100));
    }

    // NAIVE SOLUTION
    public static long solution1(int n) {
        long sum = 0;
        for (int i = 0; i < n; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }
        return sum;
    }

    // OPTIMIZED SOLUTION
    /**
     * EXPLANATION: Calculate the no. of multiples of 3 and 5 less than n.
     * Multiples of 3 = 3 (1 + 2 + 3 + ... + (n-1)/3) = 3 * (N'(N'+1)/2) = SUM3
     * Multiples of 5 = 5 (1 + 2 + 3 + ... + (n-1)/5) = 5 * (N'(N'+1)/2) = SUM5
     * Multiples of 15 = 15 (1 + 2 + 3 + ... + (n-1)/15) = 15 * (N'(N'+1)/2) = SUM15
     * 
     * Sum of all multiples of 3 and 5 = SUM3 + SUM5 - SUM15
     */
    public static long solution(int n) {
        long sum = 0;
        long n3 = (n - 1) / 3;
        long n5 = (n - 1) / 5;
        long n15 = (n - 1) / 15;

        // sum of all multiples of 3 and 5 minus sum of all multiples of 15
        long sum3 = 3 * (n3 * (n3 + 1) / 2);
        long sum5 = 5 * (n5 * (n5 + 1) / 2);
        long sum15 = 15 * (n15 * (n15 + 1) / 2);

        sum = sum3 + sum5 - sum15;
        return sum;
    }

}
