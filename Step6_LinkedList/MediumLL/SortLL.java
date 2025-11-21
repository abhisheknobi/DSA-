package Step6_LinkedList.MediumLL;

import java.util.ArrayList;
import java.util.Collections;
/*
 * Problem Statement: Given a linked list, sort its nodes 
 * based on the val value in them. Return the head of the
 *  sorted linked list.

Examples
Input: 3->4->2->1->5 
 


Output: 1->2->3->4->5


Explanation: The input linked list when sorted from 
[3, 4, 2, 1, 5] results in a linked list with values 
[1, 2, 3, 4, 5].

Input: 40->20->60->10->50->30

  
Output: 10->20->30->40->50->60


Explanation: The input linked list when sorted from
 [40, 20, 60, 10, 50, 30] results in a linked list 
 with values [10, 20, 30, 40, 50, 60].
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class SortLL {
    public static ListNode brute(ListNode head) {
          ArrayList<Integer> arr = new ArrayList<>();

        // Pointer to traverse the list
        ListNode temp = head;

        // Traverse and push values into list
        while (temp != null) {
            arr.add(temp.val);
            temp = temp.next;
        }

        // Sort the list
        Collections.sort(arr);

        // Reassign sorted values to list nodes
        temp = head;
        for (int i = 0; i < arr.size(); i++) {
            temp.val = arr.get(i);
            temp = temp.next;
        }

        // Return head of sorted list
        return head;
    }
   public static  ListNode merge(ListNode list1, ListNode list2) {
        // Create a dummy node
        ListNode dummyNode = new ListNode(-1, null);

        // Temp pointer to build merged list
        ListNode temp = dummyNode;

        // Traverse both lists
        while (list1 != null && list2 != null) {
            // Choose smaller node
            if (list1.val <= list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            // Move temp pointer
            temp = temp.next;
        }

        // Attach remaining nodes
        if (list1 != null) {
            temp.next = list1;
        } else {
            temp.next = list2;
        }

        // Return head of merged list
        return dummyNode.next;
    }

    // Function to find middle of linked list
    public static ListNode findMiddle(ListNode head) {
        // If list empty or single node
        if (head == null || head.next == null) {
            return head;
        }

        // Slow and fast pointers
        ListNode slow = head;
        ListNode fast = head.next;

        // Move fast twice as fast as slow
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Return middle node
        return slow;
    }

    public static  ListNode sortList(ListNode head) {
        // Base case: empty or single node
        if (head == null || head.next == null) {
            return head;
        }

        // Find middle node
        ListNode middle = findMiddle(head);

        // Split into two halves
        ListNode right = middle.next;
        middle.next = null;
        ListNode left = head;

        // Recursively sort both halves
        left = sortList(left);
        right = sortList(right);

        // Merge sorted halves
        return merge(left, right);
    }
    public static void main(String[] args) {
        // Example 1: 3->4->2->1->5
        ListNode head1 = new ListNode(3, new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(5)))));
        System.out.print("Original 1: ");
        for (ListNode t = head1; t != null; t = t.next) {
            System.out.print(t.val + (t.next != null ? "->" : "\n"));
        }
        ListNode sorted1 = SortLL.sortList(head1);
        System.out.print("Sorted 1: ");
        for (ListNode t = sorted1; t != null; t = t.next) {
            System.out.print(t.val + (t.next != null ? "->" : "\n"));
        }

    }     
}
