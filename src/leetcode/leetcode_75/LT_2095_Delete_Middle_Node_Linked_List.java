package leetcode.leetcode_75;

/**
 * Problem: You are given the head of a linked list. Delete the middle node, and
 * return the head of the modified linked list.
 * 
 * The middle node of a linked list of size n is the ⌊n / 2⌋th node from the
 * start using 0-based indexing, where ⌊x⌋ denotes the largest integer less than
 * or equal to x.
 * 
 * For n = 1, 2, 3, 4, and 5, the middle nodes are 0, 1, 1, 2, and 2,
 * respectively.
 * 
 * LEVEL: Medium
 * RUNTIME: 3 ms Beats 99.72% of users with Java
 * MEMORY: 63.00 MB Beats 77.45% of users with Java
 * 
 * @author Subhankar Das
 */
public class LT_2095_Delete_Middle_Node_Linked_List {

    public static void main(String[] args) {
        // TEST CASE 1
        LinkedList list = new LinkedList();
        int[] input = new int[] { 1, 3, 4, 7, 1, 2, 6 };
        for (int in : input) {
            list.insert(in);
        }
        System.out.print("List before: ");
        list.print();
        list.deleteMiddle();
        System.out.print("List after: ");
        list.print();

        // TEST CASE 2
        list = new LinkedList();
        input = new int[] { 1 };
        for (int in : input) {
            list.insert(in);
        }
        System.out.print("List before: ");
        list.print();
        list.deleteMiddle();
        System.out.print("List after: ");
        list.print();

        // TEST CASE 3
        list = new LinkedList();
        input = new int[] { 1, 2, 3, 4 };
        for (int in : input) {
            list.insert(in);
        }
        System.out.print("List before: ");
        list.print();
        list.deleteMiddle();
        System.out.print("List after: ");
        list.print();
    }

}

class ListNode {
    int val;
    ListNode next;
}

class LinkedList {

    private ListNode head;
    private ListNode tail;

    public void insert(int val) {
        if (head == null) {
            // If list is empty, add first node
            head = new ListNode();
            head.val = val;
            head.next = null;
            tail = head;
        } else {
            // If list is not empty, add new node at end
            ListNode newNode = new ListNode();
            newNode.val = val;
            newNode.next = null;

            tail.next = newNode;
            tail = newNode;
        }
    }

    public ListNode deleteMiddle() {
        ListNode slow = head, fast = head; // set fast and slow to head
        ListNode beforeDelNode = head;

        // Base case: only one node
        if (head != null && head.next == null) {
            head = null;
            return head;
        }

        // Until fast reaches the end
        while (fast != null && fast.next != null) {
            beforeDelNode = slow; // node before the node to be deleted
            slow = slow.next; // slow moves 1 step
            fast = fast.next.next; // fast moves 2 steps
        }

        beforeDelNode.next = slow.next; // delete the middle node
        slow.next = null;
        return head;
    }

    public void print() {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println();
    }
}
