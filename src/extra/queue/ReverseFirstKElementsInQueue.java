package extra.queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class ReverseFirstKElementsInQueue {

	public static void main(String[] args) {

		// Input
		String str = "ABCDEFGHI";
		int k = 4;

		// Initialize the queue
		Deque<Character> queue = new ArrayDeque<>();
		for (Character ch : str.toCharArray()) {
			queue.addLast(ch);
		}
		System.out.println(queue);

		// Output
		queue = reverseFirstKElements(queue, k);
		System.out.println(queue);

	}
	
	/**
	 * Solution
	 */
	public static Deque<Character> reverseFirstKElements(Deque<Character> queue, int k) {
		Stack<Character> stk = new Stack<>();

		// Stack first K elements from front
		for (int i = 1; i <= k; i++) {
			stk.push(queue.removeFirst());
		}

		// Add elements from stack to end
		for (int i = 1; i <= k; i++) {
			queue.addLast(stk.pop());
		}

		// Remove K elements from end and put to front
		for (int i = 1; i <= k; i++) {
			queue.addFirst(queue.removeLast());
		}

		return queue;
	}

}
