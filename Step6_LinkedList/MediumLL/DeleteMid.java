package Step6_LinkedList.MediumLL;
/*
 * Problem Statement: Given the head of a linked list of integers,
 *  delete the middle node of the linked list and return the 
 * modified head. However, if the linked list has an even number 
 * of nodes, delete the second middle node.

Examples
Input: 1->2->3->4->5 


Output: 1->2->4->5


Explanation: Node with value 3 is at the middle node and deleted.

Input: 1->2->3->4


Output: 1->2->4


Explanation: The linked list has an even number of nodes hence we
 delete the second middle node which is 3.
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

public class DeleteMid {
    public ListNode brute(ListNode head) {
        ListNode temp=head;
        int count=0;
        while(temp!=null){
            count++;
            temp=temp.next; 
        }
        if(count==1)
        return head.next;
        if(count==2){
             head.next=null;
             return head;
        }
        count=(count/2);
        
        temp=head;
        while(temp!=null ){
            if(count==1)
            break;
            count--;
            temp=temp.next;
        }
        temp.next=temp.next.next;
        return head;
}
public ListNode optimal(ListNode head) {
        if(head.next==null){
            return head.next;
        }
        ListNode slow=head;
        ListNode fast=head.next.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        slow.next=slow.next.next;
        return head;
    }
public static void main(String[] args) {
    
}
}
