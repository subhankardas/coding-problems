package leetcode.linked_list;

/**
 * Problem: You are given two non-empty linked lists representing two
 * non-negative integers. The digits are stored in reverse order, and each of
 * their nodes contains a single digit. Add the two numbers and return the sum
 * as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * 
 * 2 -> 4 -> 3
 * 
 * 5 -> 6 -> 4
 * 
 * Output: 7 -> 0 -> 8
 * 
 * Solution: Add nodes as digits and carry over as basic addition approach.
 */
public class AddTwoNumbers {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);

		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);

		print(l1);
		print(l2);

		addTwoNumbers(l1, l2);

		ListNode sum = addTwoNumbers(l1, l2);
		print(sum);
	}

	public static void print(ListNode l) {
		while (l != null) {
			System.out.print(l.val);
			l = l.next;
		}
		System.out.println();
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0);
		ListNode p = l1, q = l2, curr = head;
		int carry = 0;

		while (p != null || q != null) {
			// If node exists get digit else zero
			int x = (p != null) ? p.val : 0;
			int y = (q != null) ? q.val : 0;

			// Set sum and carry digits
			int sum = carry + x + y;
			carry = sum / 10;

			// Set new node for result with sum digit
			curr.next = new ListNode(sum % 10);
			curr = curr.next;

			if (p != null)
				p = p.next;
			if (q != null)
				q = q.next;
		}

		// Extra carry add as new digit
		if (carry > 0) {
			curr.next = new ListNode(carry);
		}

		return head.next;
	}

}

class ListNode {
	int val;
	ListNode next;

	ListNode(int val) {
		this.val = val;
	}
}