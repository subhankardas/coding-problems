package leetcode.leetcode_75;

/**
 * Problem: Given the head of a singly linked list, group all the nodes with odd
 * indices together followed by the nodes with even indices, and return the
 * reordered list.
 * 
 * The first node is considered odd, and the second node is even, and so on.
 * 
 * Note that the relative order inside both the even and odd groups should
 * remain as it was in the input.
 * 
 * You must solve the problem in O(1) extra space complexity and O(n) time
 * complexity.
 * 
 * LEVEL: Medium
 * RUNTIME: 0 ms Beats 100.00% of users with Java
 * MEMORY: 44.38 MB Beats 55.02% of users with Java
 * 
 * @author Subhankar Das
 */
public class LT_328_Odd_Even_Linked_List {

    public static void main(String[] args) {
        // TEST CASE 1
        LinkedList1 list = new LinkedList1();
        int[] input = new int[] { 1, 2, 3, 4, 5, 6, 7 };
        for (int in : input) {
            list.insert(in);
        }
        System.out.print("List before: ");
        list.print();
        list.oddEvenList();
        System.out.print("List after: ");
        list.print();
    }

}

class ListNode1 {
    int val;
    ListNode1 next;
}

class LinkedList1 {

    private ListNode1 head;
    private ListNode1 tail;

    public void insert(int val) {
        if (head == null) {
            // If list is empty, add first node
            head = new ListNode1();
            head.val = val;
            head.next = null;
            tail = head;
        } else {
            // If list is not empty, add new node at end
            ListNode1 newNode = new ListNode1();
            newNode.val = val;
            newNode.next = null;

            tail.next = newNode;
            tail = newNode;
        }
    }

    public ListNode1 oddEvenList() {
        // Base case: only one node
        if (head == null || head.next == null) {
            return head;
        }

        // If list is not empty
        ListNode1 odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) { // Until even reaches the end
            odd.next = even.next; // Odd next to even next
            odd = even.next; // New odd point to even next
            even.next = odd.next; // Even next to odd next
            even = odd.next; // New even point to odd next
        }

        odd.next = evenHead; // Join last odd node to even head
        return head;
    }

    public void print() {
        ListNode1 temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println();
    }
}
