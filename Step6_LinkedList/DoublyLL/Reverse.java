package Step6_LinkedList.DoublyLL;

class Node {
    int data;
    Node next;
    Node back;

    Node(int data1, Node next1, Node back1) {
        this.data = data1;
        this.next = next1;
        this.back = back1;
    }

    Node(int data1) {
        this.data = data1;
        this.next = null;
        this.back = null;
    }
}

public class Reverse {
    public static Node Convert2Arr(int arr[]) {
        Node head = new Node(arr[0]);
        Node prev = head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i], null, prev);
            prev.next = temp;
            prev = temp;

        }
        return head;
    }

    public static Node Reversal(Node head) {
        // Check if the list is empty
        // or has only one node
        if (head == null || head.next == null) {
            // No change is needed;
            // return the current head
            return head;
        }

        // Initialize a pointer to
        // the previous node
        Node prev = null;

        // Initialize a pointer to
        // the current node
        Node current = head;

        // Traverse the linked list
        while (current != null) {

            // Store a reference to
            // the previous node
            prev = current.back;

            // Swap the previous and
            // next pointers
            current.back = current.next;

            // This step reverses the links
            current.next = prev;

            // Move to the next node
            // in the orignal list

            current = current.back;
        }

        // The final node in the original list
        // becomes the new head after reversal
        return prev.back;

    }

    public static void main(String[] args) {
        int arr[] = { 10, 20, 30, 40, 50 };

    }

}
