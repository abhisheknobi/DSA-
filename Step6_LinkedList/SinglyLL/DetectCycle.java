package Step6_LinkedList.SinglyLL;

import java.util.HashMap;
import java.util.Map;

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

public class DetectCycle {

    public static boolean brute(Node head) {
        Map<Node, Integer> mpp = new HashMap<>();
        Node temp = head;
        while (temp != null) {
            if (mpp.containsKey(temp))
                return true;
            else
                mpp.put(temp, 1);
            temp = temp.next;
        }
        return false;
    }

    public static void main(String[] args) {
        // Create a sample linked list
        // with a loop for testing
        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        // Create a loop
        fifth.next = third;

        // Check if there is a loop
        // in the linked list
        if (brute(head)) {
            System.out.println("Loop detected in the linked list.");
        } else {
            System.out.println("No loop detected in the linked list.");
        }

    }

}
