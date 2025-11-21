package Step6_LinkedList.MediumLL;
/*
 * Given a LinkedList of integers. Modify the LinkedList in such 
 * \a way that in Modified LinkedList all the even numbers appear
 *  before all the odd numbers in LinkedList.

Also, note that the order of even and odd numbers should remain the
 same. 

Examples:

Example 1:
Input: 1→2→3→4→5→6→Null
Output: 2→4→6→1→3→5→Null
Explanation : 
Odd Nodes in LinkedList are 1,3,5 and 
Even Nodes in LinkedList are 2,4,6
In Modified LinkedList all even Nodes comes before 
all Odd Nodes. So Modified LinkedList looks like 
2→4→6→1→3→5→Null. Order of even and odd Nodes is 
maintained in modified LinkedList.

Example 2:
Input: 1→3→5→Null
Output: 1→3→5→Null
Explantion: As there are no Even Nodes in LinkedList, 
The Modified LinkedList is same as Original LinkedList.

Example 3:
Input: 2→4→6→8→Null
Output: 2→4→6→8→Null
Explanation: As there are no Odd Nodes in LinkedList, 
The Modified LinkedList is same as Original LinkedList.
 */
public class OddEven {
    public ListNode oddEvenList(ListNode head) {
        // If the list is empty, has one node, or two nodes, no change is needed.
        if (head == null || head.next == null) {
            return head;
        }

        // 'odd' pointer starts at the first node (index 0, which is odd position 1)
        ListNode odd = head;
        // 'even' pointer starts at the second node (index 1, which is even position 2)
        ListNode even = head.next;
        // Keep a reference to the head of the even list
        ListNode evenHead = even;

        // Loop as long as there is an even node and a node after it to link to
        while (even != null && even.next != null) {
            // Connect the current odd node to the next odd node
            odd.next = even.next;
            // Move the odd pointer forward
            odd = odd.next;

            // Connect the current even node to the next even node
            even.next = odd.next;
            // Move the even pointer forward
            even = even.next;
        }

        // Connect the end of the odd list to the beginning of the even list
        odd.next = evenHead;

        // Return the original head, which is the head of the modified list
        return head;
    }
    public static void main(String[] args) {
        OddEven obj = new OddEven();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode ans = obj.oddEvenList(head);
        while (ans != null) {
            System.out.print(ans.val + " ");
            ans = ans.next;
        }
        
        
    }
    
}
