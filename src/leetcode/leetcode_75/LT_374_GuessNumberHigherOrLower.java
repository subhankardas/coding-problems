package leetcode.leetcode_75;

public class LT_374_GuessNumberHigherOrLower {

    private final static int GUESS = 6;

    public static void main(String[] args) {
        System.out.println(guessNumber(10));
    }

    public static int guessNumber(int n) {
        return checkNum(1, n);
    }

    public static int checkNum(int low, int high) {
        int mid = low + (high - low) / 2;
        return switch (guess(mid)) {
            case 0 -> mid;
            case 1 -> checkNum(mid + 1, high);
            default -> checkNum(low, mid - 1);
        };
    }

    // Guess API //
    public static int guess(int n) {
        if (n > GUESS)
            return -1;
        if (n < GUESS)
            return 1;
        return 0;
    }

}