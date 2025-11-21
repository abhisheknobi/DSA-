package Step6_LinkedList.MediumLL;
/*
 * Problem Statement: Add two numbers represented as Linked Lists.

Examples

Example 1:
Input: num1 = 243, num2 = 564
Output:sum = 807; L = [7,0,8]



Explanation: Since the digits are stored in reverse order, reverse 
the numbers first to get the or original number and then add them
 as → 342 + 465 = 807. 

Example 2:
Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: Result: [8,9,9,9,0,0,0,1]



Explanation: Since the digits are stored in reverse order, reverse the
 numbers first to get the original number and then add them as 
 → 9999999 + 9999 = 8999001. Refer to the image below.
 */
public class AddLL {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       //Initialize a dummy node as a new node
        ListNode dummy = new ListNode(); 
        ListNode temp = dummy; 
        int carry = 0;
        //Iterate till the end of both the lists
        while (l1 != null || l2 != null || carry != 0) {
            int sum = 0;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
             //Repeat the same process for l2 as l1
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            //Carry gets added to sum in the node (carry=sum/10)
            sum += carry;
            carry = sum / 10;

            ListNode node = new ListNode(sum % 10);
            temp.next = node;
            temp = temp.next;
        }

        return dummy.next;
    }

public static ListNode createList(int[] arr) {
        ListNode head = new ListNode(arr[0]);
        ListNode temp = head;
        for (int i = 1; i < arr.length; i++) {
            temp.next = new ListNode(arr[i]);
            temp = temp.next;
        }
        return head;
    }

    static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] num1 = {2, 4, 3}; // represents 342
        int[] num2 = {5, 6, 4}; // represents 465
        ListNode l1 = createList(num1);
        ListNode l2 = createList(num2);

        ListNode result = addTwoNumbers(l1, l2);
        printList(result); // Output: 7 -> 0 -> 8
    }

    
}
