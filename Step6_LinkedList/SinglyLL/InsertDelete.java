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

public class InsertDelete {
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

    private static Node InsertAtBegin(Node head, int data) {
        Node newnode = new Node(data);
        newnode.next = head;
        head = newnode;
        return head;
    }

    private static Node InsertAtEnd(Node head, int data) {
        Node newnode = new Node(data);
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newnode;
        return head;
    }

    private static Node InsertAtPos(Node head, int data, int pos) {
        Node newNode = new Node(data);
        if (pos == 0) {
            head = InsertAtBegin(head, data);
        } else {
            Node temp = head;
            for (int i = 1; i < pos; i++) {
                if (temp == null || temp.next == null) {
                    // Position out of bounds, do nothing or throw exception
                    return head;
                }
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }
        return head;
    }

    private static Node DeleteBegin(Node head) {
        head = head.next;
        return head;
    }

    private static Node deleteEnd(Node head) {
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }

    private static Node deleteAtPos(Node head, int pos) {
        if (pos == 0) {
            head = DeleteBegin(head);
        } else {
            Node temp = head;
            for (int i = 1; i < pos; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 3, 4, 5 };
        Node head = Convert2Arr(arr);
        head = InsertAtBegin(head, 1);
        head = InsertAtEnd(head, 6);
        head = InsertAtPos(head, 9, 3);
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
        System.out.println("After Deletion");
        head = DeleteBegin(head);
        head = deleteEnd(head);
        head = deleteAtPos(head, 2);
        temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }

    }

}
