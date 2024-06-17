package hackerrank.project_euler;

public class ProjectEuler_2_EvenFibonacciNumbers {

    public static void main(String[] args) {
        System.out.println(solution1(100));
        System.out.println(solution(100));

        System.out.println(solution1(1000));
        System.out.println(solution(1000));
    }

    public static long solution1(long n) {
        long sum = 0;
        long a = 1;
        long b = 2;
        long c = 0;

        while (b <= n) {
            if (b % 2 == 0) {
                sum += b;
            }
            c = a + b;
            a = b;
            b = c;
        }
        return sum;
    }

    public static long solution(long n) {
        if (n <= 2) {
            return 2;
        }

        long sum = 0;
        long n1 = 1, n2 = 2, n3 = 0;
        char s1 = 'o', s2 = 'e', s3 = ' ';
        while ((n1 + n2) <= n) {
            n3 = n1 + n2;
            if (s1 == 'o' && s2 == 'e' || s1 == 'e' && s2 == 'o') {
                s3 = 'o';
            } else {
                s3 = 'e';
            }
            if (s3 == 'e') {
                sum += n3;
            }

            n1 = n2;
            n2 = n3;

            s1 = s2;
            s2 = s3;
        }
        return sum + 2;
    }

}
