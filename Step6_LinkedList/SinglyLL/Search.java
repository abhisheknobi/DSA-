package Step6_LinkedList.SinglyLL;

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

public class Search {
    private static Node Convert2Arr(int arr[]) {
        Node head = new Node(arr[0]);
        Node temp = head;
        for (int i = 1; i < arr.length; i++) {
            Node newnode = new Node(arr[i]);
            temp.next = newnode;
            temp = newnode;
        }
        return head;
    }

    private static boolean SearchIterative(Node head, int key) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == key) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    private static boolean SearchRecursive(Node head, int key) {
        if (head == null) {
            return false;
        }
        if (head.data == key) {
            return true;
        }
        return SearchRecursive(head.next, key);
    }

    public static void main(String[] args) {
        int arr[] = { 10, 20, 30, 40, 50 };
        Node head = Convert2Arr(arr);
        int key = 30;
        System.out.println("Is " + key + " present (Iterative)? " + SearchIterative(head, key));
        System.out.println("Is " + key + " present (Recursive)? " + SearchRecursive(head, key));
    }

}
