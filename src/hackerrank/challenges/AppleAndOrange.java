package hackerrank.challenges;

import java.util.List;

// https://www.hackerrank.com/challenges/apple-and-orange
public class AppleAndOrange {

    public static void main(String[] args) {
        countApplesAndOranges(7, 10, 4, 12, List.of(2, 3, -4), List.of(3, -2, -4));
        countApplesAndOranges(7, 11, 5, 15, List.of(-2, 2, 1), List.of(5, -6));
    }

    public static void countApplesAndOranges(int s, int t, int a, int b, List<Integer> apples, List<Integer> oranges) {
        int applesCount = 0;
        int orangesCount = 0;

        for (int i = 0; i < apples.size(); i++) {
            int applesPos = apples.get(i) + a;
            if (applesPos >= s && applesPos <= t)
                applesCount++;
        }

        for (int i = 0; i < oranges.size(); i++) {
            int orangesPos = oranges.get(i) + b;
            if (orangesPos >= s && orangesPos <= t)
                orangesCount++;
        }

        System.out.println(applesCount);
        System.out.println(orangesCount);
    }

}
