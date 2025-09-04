package Step6_LinkedList.SinglyLL;

/*
 * Problem Statement: Problem Statement: Given the head of a singly linked 
 * list, write a program to reverse the linked list, and return the head 
 * pointer to the reversed list.

Example 1:
Input Format:
LL: 1   3   2   4 
Output: 3
Explanation: After reversing the linked list, the new head will point to
 the tail of the old linked list.


Example 2:
Input Format:
LL: 4
Output: 4
Explanation: In this example, the linked list contains only one node hence
 reversing this linked list will result in the same list as the original.
 */
import java.util.Deque;
import java.util.ArrayDeque;

class Node {
    int data;
    Node next;

    Node(int data1, Node next1) {
        this.data = data1;
        this.next = next1;
    }

    Node(int data1) {
        this.data = data1;
        this.next = null;
    }
}

public class Reverse {
    public static Node Convert2Arr(int arr[]) {
        Node head = new Node(arr[0]);
        Node temp = head;
        for (int i = 1; i < arr.length; i++) {
            Node newnode = new Node(arr[i]);
            temp.next = newnode;
            temp = newnode;
        }
        return head;
    }

    public static Node brute(Node head) {
        Node temp = head;
        Deque<Integer> stack = new ArrayDeque<>();
        while (temp != null) {
            stack.push(temp.data);
            temp = temp.next;
        }
        temp = head;
        while (temp != null) {
            temp.data = stack.pop();
            temp = temp.next;
        }
        return head;
    }

    public static void printLL(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

    }

    public Node optimalIterative(Node head) {
        if (head == null)
            return null;
        Node temp = head;
        Node prev = null;
        Node actualnext = head;

        while (temp != null) {
            actualnext = temp.next;
            temp.next = prev;
            prev = temp;
            temp = actualnext;
        }

        return prev;
    }

    public static Node optimalRecursive(Node head) {
        if (head == null || head.next == null)
            return head;
        Node newhead = optimalRecursive(head.next);
        Node front = head.next;
        front.next = head;
        head.next = null;
        return newhead;
    }

    public static void main(String[] args) {
        int arr[] = { 10, 20, 30, 40, 50 };
        Node head = Convert2Arr(arr);
        head = optimalRecursive(head);
        printLL(head);

    }

}
