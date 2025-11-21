package Step6_LinkedList.MediumLL;
/*
 * Problem Statement: Given the heads of two singly linked-lists
 *  headA and headB, return the node at which the two lists 
 * intersect. If the two linked lists have no intersection 
 * at all, return null.

Examples:

Example 1:
Input:
List 1 = [1,3,1,2,4], List 2 = [3,2,4]
Output:
2
Explanation: Here, both lists intersecting nodes start from 
node 2.

Example 2:
Input:
 List1 = [1,2,7], List 2 = [2,8,1]
Output:
 Null
Explanation: Here, both lists do not intersect and thus no 
intersection node is present.
 */
import java.util.HashSet;
 class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
public class Intersection {
    public static ListNode brute(ListNode head1, ListNode head2){
        while(head2 != null) {
        ListNode temp = head1;
        while(temp != null) {
            //if both nodes are same
            if(temp == head2) return head2;
            temp = temp.next;
        }
        head2 = head2.next;
    }
    return null; //intersection is not present between the lists
}

    public static ListNode hash(ListNode head1, ListNode head2){
        HashSet<ListNode> set = new HashSet<>();

        // Traverse the first linked list and store each node in the set
        ListNode temp1 = head1;
        while (temp1 != null) {
            set.add(temp1);
            temp1 = temp1.next;
        }

        // Traverse the second linked list and check for intersection
        ListNode temp2 = head2;
        while (temp2 != null) {
            if (set.contains(temp2)) {
                return temp2; // Intersection found
            }
            temp2 = temp2.next;
        }   
    //intersection is not present between the lists return null
    return null;
    }


    public static ListNode optimal(ListNode head1, ListNode head2){
        if(head1 == null || head2 == null) return null;

        ListNode ptr1 = head1;
        ListNode ptr2 = head2;

        // Traverse both lists
        while(ptr1 != ptr2) {
            // Move to the next node or switch to the head of the other list
            ptr1 = (ptr1 == null) ? head2 : ptr1.next;
            ptr2 = (ptr2 == null) ? head1 : ptr2.next;
        }

        // Either both pointers meet at the intersection node or at null
        return ptr1;
    }
    public static ListNode insertNode(ListNode head,int val) {
    ListNode newNode = new ListNode(val);
    
    if(head == null) {
        head = newNode;
        return head;
    }
    
    ListNode temp = head;
    while(temp.next != null) temp = temp.next;
    
    temp.next = newNode;
    return head;
}

public static void printList(ListNode head) {
    while(head.next != null) {
    System.out.print(head.val+"->");
        head = head.next;
    }
    System.out.println(head.val);
}
    public static void main(String[] args) {
        // You can create linked lists and test the methods here
        ListNode head = null;
    head=insertNode(head,1);
    head=insertNode(head,3);
    head=insertNode(head,1);
    head=insertNode(head,2);
    head=insertNode(head,4);
    ListNode head1 = head;
    head = head.next.next.next;
    ListNode headSec = null;
    headSec=insertNode(headSec,3);
    ListNode head2 = headSec;
    headSec.next = head;
    //printing of the lists
    System.out.print("List1: "); printList(head1);
    System.out.print("List2: "); printList(head2);
    //checking if intersection is present
    ListNode answerNode = optimal(head1,head2);
    if(answerNode == null)  
    System.out.println("No intersection\n");
    else
    System.out.println("The intersection point is "+answerNode.val);
        
    }
 
}
