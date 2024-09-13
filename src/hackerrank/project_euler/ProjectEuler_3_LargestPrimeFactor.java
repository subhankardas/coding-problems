package hackerrank.project_euler;

public class ProjectEuler_3_LargestPrimeFactor {

    public static void main(String[] args) {
        System.out.println(solution(100));
        System.out.println(solution(17));
    }

    public static long solution(long n) {
        long maxPrimeFactor = -1;

        while (n % 2 == 0) { // Remove all even factors
            maxPrimeFactor = 2;
            n >>= 1;
        }

        for (int i = 3; i * i <= n; i += 2) { // Remove all odd factors
            while (n % i == 0) {
                maxPrimeFactor = i;
                n /= i;
            }
        }

        if (n > 2) { // If n is a prime number
            maxPrimeFactor = n;
        }
        return maxPrimeFactor;
    }

}
