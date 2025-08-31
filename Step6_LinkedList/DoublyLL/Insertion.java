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

public class Insertion {

    private static Node Convert2Arr(int arr[]) {
        Node head = new Node(arr[0]);
        Node prev = head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i], null, prev);
            prev.next = temp;
            prev = temp;
        }
        return head;
    }

    private static Node InsertAtBegin(Node head, int data) {
        Node newnode = new Node(data, head, null);
        head.back = newnode;
        head = newnode;
        return head;
    }

    private static Node InsertAtEnd(Node head, int data) {
        Node newnode = new Node(data);
        Node temp = head;
        while (temp.next != null)
            temp = temp.next;

        temp.next = newnode;
        newnode.back = temp;
        temp = newnode;
        return head;

    }

    private static Node InsertAtPos(Node head, int data, int pos) {
        Node newnode = new Node(data);
        if (pos == 0)
            head = InsertAtBegin(head, data);
        else {
            Node temp = head;
            for (int i = 1; i < pos; i++) {
                if (temp == null || temp.next == null) {
                    // Position out of bounds, do nothing or throw exception
                    return head;
                }
                temp = temp.next;
            }
            newnode.next = temp.next;
            newnode.back = temp;
            if (temp.next != null)
                temp.next.back = newnode;
            temp.next = newnode;
            temp = newnode;

        }
        return head;
    }

    private static Node DeleteBegin(Node head) {
        if (head == null || head.next == null)
            return null;
        Node prev = head;
        head = head.next;
        head.back = null;
        prev.next = null;
        prev.back = null;
        return head;
    }

    private static Node DeleteEnd(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.back.next = null;
        temp.back = null;
        return head;
    }

    private static Node DeleteAtPos(Node head, int pos) {
        Node temp = head;
        int cnt = 0;
        while (temp != null) {
            cnt++;
            if (cnt == pos)
                break;
            temp = temp.next;
        }

        Node prev = temp.back;
        Node front = temp.next;

        if (prev == null && front == null)
            return head;

        else if (prev == null) {
            DeleteBegin(head);
            return head;
        } else if (front == null) {
            DeleteEnd(head);
            return head;
        } else {
            prev.next = front;
            front.back = prev;
            temp.next = null;
            temp.back = null;
            return head;
        }
    }

    public static void main(String[] args) {
        int arr[] = { 10, 20, 30, 40, 50 };
        Node head = Convert2Arr(arr);
        head = InsertAtBegin(head, 5);
        head = InsertAtEnd(head, 60);
        head = InsertAtPos(head, 25, 3);
        head = DeleteBegin(head);
        head = DeleteEnd(head);
        head = DeleteAtPos(head, 2);
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }

    }

}
