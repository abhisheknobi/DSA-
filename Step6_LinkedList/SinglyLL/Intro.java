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

public class Intro {
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

    private static int LengthOfLL(Node head) {
        int cnt = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {

        int arr[] = { 2, 3, 4, 5 };
        Node head = Convert2Arr(arr);
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
        System.out.println("Length of LL is: " + LengthOfLL(head));

    }
}
