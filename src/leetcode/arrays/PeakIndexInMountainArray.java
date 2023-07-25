package leetcode.arrays;

public class PeakIndexInMountainArray {

    public static void main(String[] args) {
        System.out.println(peakIndexInMountainArray(new int[] { 0, 2, 3, 4, 5, 2, 1, 0 }));
    }

    public static int peakIndexInMountainArray(int[] arr) {
        int peak = 0;
        for (int idx = 1; idx < arr.length - 1; idx++) {
            if (arr[idx - 1] < arr[idx] && arr[idx] > arr[idx + 1]) {
                peak = idx;
            }
        }
        return peak;
    }

}
