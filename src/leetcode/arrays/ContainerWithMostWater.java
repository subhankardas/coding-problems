package leetcode.arrays;

/**
 * Container With Most Water: Given n non-negative integers a1, a2, ..., an ,
 * where each represents a point at coordinate (i, ai). n vertical lines are
 * drawn such that the two endpoints of the line i is at (i, ai) and (i, 0).
 * Find two lines, which, together with the x-axis forms a container, such that
 * the container contains the most water.
 * 
 * https://leetcode.com/problems/container-with-most-water/
 */
public class ContainerWithMostWater {

	public static void main(String[] args) {
		int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		System.out.println(maxArea(height));
	}

	public static int maxArea(int[] height) {
		int len = height.length;
		int start = 0, end = len - 1; // Pointers for both ends of container
		int r1 = 0, r2 = 0, area = 0, currArea = 0;

		// While container range is valid
		while (start < end) {
			r1 = height[start];
			r2 = height[end];

			// Move start forward if lesser than end height, else vice-versa
			if (r1 < r2) {
				currArea = r1 * (end - start);
				start++;
			} else {
				currArea = r2 * (end - start);
				end--;
			}

			// Compare and store the max. area value
			area = Math.max(area, currArea);
		}

		return area;
	}

}
