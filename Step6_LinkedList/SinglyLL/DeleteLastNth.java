package Step6_LinkedList.SinglyLL;
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

    public static ListNode brute(ListNode head,int n){
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode first=dummy;
        ListNode second=dummy;

        //Move first pointer n+1 steps ahead
        for(int i=0;i<=n;i++){
            first=first.next;
        }

        //Move both pointers until first reaches the end
        while(first!=null){
            first=first.next;
            second=second.next;
        }

        //Delete the nth node from the end
        second.next=second.next.next;

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
