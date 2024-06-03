package leetcode.leetcode_75;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Problem: Given two 0-indexed integer arrays nums1 and nums2, return a list
 * answer of size 2 where:
 * 
 * answer[0] is a list of all distinct integers in nums1 which are not present
 * in nums2.
 * answer[1] is a list of all distinct integers in nums2 which are not present
 * in nums1.
 * Note that the integers in the lists may be returned in any order.
 * 
 * Level: Easy
 * RUNTIME: 10 ms Beats 80.99% of users with Java
 * MEMORY: 45.18 MB Beats 81.08% of users with Java
 * 
 * @author Subhankar Das
 */
public class LT_2215_Find_Difference_Two_Arrays {

    public static void main(String[] args) {
        System.out.println(findDifference(new int[] { 1, 2, 3 }, new int[] { 2, 4, 6 }));
        System.out.println(findDifference(new int[] { 1, 2, 3, 3 }, new int[] { 1, 1, 2, 2 }));
    }

    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        result.add(new ArrayList<>());

        // add nums1 elements to set
        Set<Integer> elems1 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            elems1.add(nums1[i]);
        }

        // add nums2 elements to another set
        Set<Integer> elems2 = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            elems2.add(nums2[i]);
        }

        // from set1 skip elements in set2 for result 0
        for (Integer val1 : elems1) {
            if (!elems2.contains(val1)) {
                result.get(0).add(val1);
            }
        }

        // from set2 skip elements in set1 for result 1
        for (Integer val2 : elems2) {
            if (!elems1.contains(val2)) {
                result.get(1).add(val2);
            }
        }

        return result;
    }

}
