package Step6_LinkedList.MediumLL;
import java.util.ArrayDeque;
/*
 * Example 1:

Input Format:

LL: 1  2  3  2  1


Output: True

Explanation: A linked list with values "1 2 3 2 1" is
 a palindrome because its elements read the same from
  left to right and from right to left, making it 
  symmetrical and mirroring itself.

Example 2:

Input Format:

LL: 1 2 3 3 2 1 


Output: True

Explanation: A linked list with values "1 2 3 3 2 1" is 
a palindrome because it reads the same forwards and backwards.

Example 3:

Input Format:

LL: 1 2 3 2 3


Output: False

Explanation: The linked list "1 2 3 2 3" is not a palindrome 
because it reads differently in reverse order, where 
"3 2 3 2 1" is not the same as the original sequence
"1 2 3 2 3."
 */
import java.util.Deque;

public class Palindrome {
    // Local Node class to represent singly linked list nodes
    public static class Node {
        public int data;
        public Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static void printLinkedList(Node head){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }
    public static boolean brute(Node head){
        Deque<Integer> stack=new ArrayDeque<>();
        Node temp=head;
        while(temp!=null){
            stack.push(temp.data);
            temp=temp.next;
        }
        temp=head;
        while(temp!=null){
            if(temp.data!=stack.peek())
            return false;
            stack.pop();
            temp=temp.next;
        }
        return true;
    }
     // Function to reverse a linked list
    // using the recursive approach
    public static Node reverseLinkedList(Node head) {
        // Check if the list is empty or has only one node
        if (head == null || head.next == null) {

            // No change is needed;
            // return the current head
            return head;
        }

        // Recursive step: Reverse the remaining
        // part of the list and get the new head
        Node newHead = reverseLinkedList(head.next);

        // Store the next node in 'front'
        // to reverse the link
        Node front = head.next;

        // Update the 'next' pointer of 'front' to
        // point to the current head, effectively
        // reversing the link direction
        front.next = head;

        // Set the 'next' pointer of the
        // current head to 'null' to
        // break the original link
        head.next = null;

        // Return the new head obtained
        // from the recursion
        return newHead;
    }
    
    public static boolean isPalindrome(Node head) {
        // Check if the linked list is
        // empty or has only one node
        if (head == null || head.next == null) {
            // It's a palindrome by definition
            return true;
        }
    
        // Initialize two pointers, slow and fast,
        // to find the middle of the linked list
        Node slow = head;
        Node fast = head;
    
        //Here we need the 1st middle for odd and even length L
        // that is why we are using fast.next and fast.next.next
        while (fast.next != null && fast.next.next != null) {
            // Move slow pointer one step at a time
            slow = slow.next;
    
            // Move fast pointer two steps at a time
            fast = fast.next.next;
        }
    
        // Reverse the second half of the 
        // linked list starting from the middle
        Node newHead = reverseLinkedList(slow.next);
    
        // Pointer to the first half
        Node first = head;
    
        // Pointer to the reversed second half
        Node second = newHead;
        while (second != null) {
            // Compare data values of
            // nodes from both halves
    
            // If values do not match, the
            // list is not a palindrome
            if (first.data != second.data) {
                
                // Reverse the second half back
                // to its original state
                reverseLinkedList(newHead);
    
                // Not a palindrome
                return false;
            }
    
            // Move the first pointer
            first = first.next;
    
            // Move the second pointer
            second = second.next;
        }
    
        // Reverse the second half back
        // to its original state
        reverseLinkedList(newHead);
    
        // The linked list is a palindrome
        return true;
    }   


    public static void main(String[] args) {
          // Create a linked list with
        // values 1, 5, 2, 5, and 1 (15251, a palindrome)
        Node head = new Node(1);
        head.next = new Node(5);
        head.next.next = new Node(2);
        head.next.next.next = new Node(5);
        head.next.next.next.next = new Node(1);

        // Print the original linked list
        System.out.print("Original Linked List: ");
        printLinkedList(head);

        // Check if the linked list is a palindrome
        if (brute(head)) {
            System.out.println("The linked list is a palindrome.");
        } else {
            System.out.println("The linked list is not a palindrome.");
        }
    }
    
}
