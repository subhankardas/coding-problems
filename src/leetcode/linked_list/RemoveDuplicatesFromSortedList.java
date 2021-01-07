package leetcode.linked_list;

/**
 * Remove duplicates from sorted linked list.
 */
public class RemoveDuplicatesFromSortedList {

	static Node head;

	public static void main(String[] args) {
		createSortedListWithDuplicates();
		printList();

		removeDuplicates();
		printList();
	}

	public static void createSortedListWithDuplicates() {
		head = new Node(13);
		Node n1 = new Node(13);
		Node n2 = new Node(42);
		Node n3 = new Node(67);
		Node n4 = new Node(67);

		// Create linked list
		head.next = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = null;
	}

	public static void printList() {
		Node trav = head;
		while (trav != null) {
			System.out.print(" -> " + trav.data);
			trav = trav.next;
		}
		System.out.println();
	}

	public static void removeDuplicates() {
		Node last = head;

		if (head == null || head.next == null)
			return;

		Node trav = head.next;
		while (trav != null) {
			// If last node i.e. unique and current node has same value skip
			// Else set this node as last unique node and proceed.
			if (last.data != trav.data) {
				last.next = trav;
				last = trav;
			}
			trav = trav.next;
		}
		last.next = null; // End list at the last unique node
	}
}

class Node {
	int data;
	Node next;

	Node(int dt) {
		data = dt;
		next = null;
	}
}