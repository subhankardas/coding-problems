package hackerrank.sorting;

import java.util.HashMap;
import java.util.Map;

public class ActivityNotifications {

	public static void main(String[] args) {

		int[] expenditure = { 2, 3, 4, 2, 3, 6, 8, 4, 5 };
		int d = 5;

		System.out.println(activityNotifications(expenditure, d));

	}

	static int activityNotifications(int[] expenditure, int d) {
		int len = expenditure.length;
		int notifications = 0;

		Map<Integer, Integer> data = new HashMap<>();

		// Collect data from previous expenditures
		for (int idx = 0; idx < d; idx++) {
			if (data.containsKey(expenditure[idx]))
				data.put(expenditure[idx], data.get(expenditure[idx]) + 1);
			else
				data.put(expenditure[idx], 1);
		}

		int start = 0; // Window start

		// Loop through next expenditures for calculation
		for (int idx = d; idx < len; idx++) {
			double median = 0;

			// Calculate median
			if (d % 2 == 0) {
				median = (getData(data, d / 2) + getData(data, (d / 2) + 1)) / 2.0;
			} else {
				median = getData(data, (d / 2) + 1);
			}

			// Evaluate notifications count
			if (expenditure[idx] >= median * 2)
				notifications++;

			// Add current expenditure to data
			if (data.containsKey(expenditure[idx])) {
				data.put(expenditure[idx], data.get(expenditure[idx]) + 1);
			} else {
				data.put(expenditure[idx], 1);
			}

			// Remove start expenditure from data
			if (data.containsKey(expenditure[start])) {
				data.put(expenditure[start], data.get(expenditure[start]) - 1);
			} else {
				data.put(expenditure[start], 0);
			}

			start++; // Move window forward
		}

		return notifications;
	}

	// Implement counting sort to get element at index.
	static int getData(Map<Integer, Integer> data, int idx) {
		int count = 0;

		// Loop through possible values
		for (int exp = 0; exp <= 200; exp++) {
			if (data.containsKey(exp))
				count += data.get(exp);

			// Elements count reached desired index
			if (count >= idx)
				return exp;
		}
		return 0;
	}

}
