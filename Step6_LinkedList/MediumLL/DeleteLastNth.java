package Step6_LinkedList.MediumLL;

/*
 * Problem Statement: Given a linked list and an integer N,
 *  the task is to delete the Nth node from the end of the 
 * linked list and print the updated linked list.

Examples
Example 1:
Input Format: 5->1->2, N=2
Result: 5->2
Explanation: The 2nd node from the end of the linked list is 1. 
Therefore, we get this result after removing 1 from the linked list.

Example 2:
Input Format: 1->2->3->4->5, N=3
Result: 1->2->4->5
Explanation: The 3rd node from the end is 3, therefore, we remove
 3 from the linked list.

 */
class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
public class DeleteLastNth {

    public static ListNode brute(ListNode head, int n) {
        
        if(head==null ){
            return head;
        }
        
        ListNode temp=head;
          int count=0;
        while(temp!=null){
           count++;
           temp=temp.next;
        }
        if (count == n) {
            return head.next;
        }
        int del=count-n;
        temp=head;
        while (temp!= null) {
            del--;
            if (del == 0) {
                break;
            }
            temp = temp.next;
        }

        // Delete the node
        temp.next = temp.next.next;
        return head;
    }
     public Node optimal(Node head, int N) {
        // Create a dummy node before head to handle edge cases
        Node dummy = new Node(0, head);

        // Initialize slow and fast pointers at dummy
        Node slow = dummy;
        Node fast = dummy;

        // Move fast pointer N+1 steps ahead to create a gap
        for (int i = 0; i <= N; i++) {
            fast = fast.next;
        }

        // Move both pointers until fast reaches the end
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // Slow is now at node before target → delete target node
        slow.next = slow.next.next;

        // Return updated head
        return dummy.next;
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        int n = 2;
        ListNode ans = brute(head, n);
        while (ans != null) {
            System.out.print(ans.val + " ");
            ans = ans.next;
        }
        
    }
    
}
