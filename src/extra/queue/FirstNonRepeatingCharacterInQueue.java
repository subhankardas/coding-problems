package extra.queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingCharacterInQueue {

	public static void main(String[] args) {

		// Input
		String str = "ABCDECEFE";

		// Initialize the queue
		Deque<Character> queue = new ArrayDeque<>();
		for (Character ch : str.toCharArray()) {
			queue.addLast(ch);
		}
		System.out.println(queue);

		// Output
		char ch = getNextNonRepeatingCharacter(frequencyMap(queue), queue);
		System.out.println(ch);

	}

	// Counts the frequency of characters and returns in a map.
	public static Map<Character, Integer> frequencyMap(Deque<Character> queue) {
		Map<Character, Integer> count = new HashMap<>();

		for (Character ch : queue) {
			if (count.get(ch) == null)
				count.put(ch, 1);
			else
				count.put(ch, count.get(ch) + 1);
		}

		return count;
	}

	// Gets the next non repeating character in a queue based on frequency map.
	public static char getNextNonRepeatingCharacter(Map<Character, Integer> frequency, Deque<Character> queue) {
		if (queue.size() == 0)
			return '-';

		char ch = queue.removeFirst();
		if (frequency.get(ch) == 1)
			return ch;
		else
			return getNextNonRepeatingCharacter(frequency, queue);
	}

}
