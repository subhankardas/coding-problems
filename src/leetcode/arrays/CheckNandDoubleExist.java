package leetcode.arrays;

import java.util.HashMap;
import java.util.Map;

public class CheckNandDoubleExist {

	public static void main(String[] args) {

		int[] arr = { 3, 1, 7, 11 };

		// Solution
		boolean res = false;
		Map<Integer, Integer> map = new HashMap<>();
		for (int elem : arr) {
			// If map has element i.e. element x 2 or element / 2
			if (map.get(elem * 2) != null || (map.get(elem / 2) != null && elem % 2 == 0)) {
				res = true;
				break;
			} else {
				// Else add this element to map
				map.put(elem, 0);
			}
		}

		// Answer
		System.out.println(res);

	}

}
