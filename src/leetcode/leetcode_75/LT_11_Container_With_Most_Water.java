package leetcode.leetcode_75;

public class LT_11_Container_With_Most_Water {

    public static void main(String[] args) {
        System.out.println(maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }));
    }

    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int leftHeight, rightHeight;
        int area = 0, curArea = 0;

        while (left < right) { // keep shrinking the window
            leftHeight = height[left];
            rightHeight = height[right];

            curArea = Math.min(leftHeight, rightHeight) * Math.abs(left - right); // calculate current area
            area = Math.max(area, curArea);

            if (leftHeight < rightHeight) { // left height is smaller, move left inwards
                left++;
            } else { // right height is smaller, move right inwards
                right--;
            }
        }
        return area;
    }

}
