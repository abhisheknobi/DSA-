package Step6_LinkedList.MediumLL;
/*
 * Problem Statement: Given the head of a singly linked list
 *  representing a positive integer number. Each node of the
 *  linked list represents a digit of the number, with the 
 * 1st node containing the leftmost digit of the number and
 *  so on. The task is to add one to the value represented by
 *  the linked list and return the head of a linked list 
 * containing the final value.

The number will contain no leading zeroes except when the
 value represented is zero itself.

Examples
Input: 4->5->6
Output: 4->5->7
Explanation: 456 + 1 = 457

Input: 9->9->9
Output: 1->0->0->0
Explanation: 999 + 1 = 1000
 */

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class AddOne {

    // Reverse a linked list
    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode temp = head;

        while (temp != null) {
            ListNode nextNode = temp.next;
            temp.next = prev;
            prev = temp;
            temp = nextNode;
        }
        return prev;
    }

    // Add one to the number represented by the Linked List
    public static ListNode iterative(ListNode head) {
        head = reverse(head);

        ListNode temp = head;
        int carry = 1;

        while (temp != null && carry > 0) {
            int sum = temp.val + carry;
            temp.val = sum % 10;
            carry = sum / 10;

            if (temp.next == null && carry > 0) {
                temp.next = new ListNode(carry);
                carry = 0; 
            }

            temp = temp.next;
        }

        return reverse(head);
    }

    // Insert at end
    public static ListNode insertNode(ListNode head, int val) {
        ListNode newNode = new ListNode(val);

        if (head == null) {
            return newNode;
        }

        ListNode temp = head;
        while (temp.next != null) temp = temp.next;

        temp.next = newNode;
        return head;
    }

    // Print list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print("->");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        ListNode head = null;

        head = insertNode(head, 4);
        head = insertNode(head, 5);
        head = insertNode(head, 6);

        System.out.print("Original: ");
        printList(head);

        ListNode ans = iterative(head);

        System.out.print("After Adding One: ");
        printList(ans);
    }
}
