package Step6_LinkedList.SinglyLL;


/*
 * Given the head of a linked list, return the node where 
 * the cycle begins. If there is no cycle, return null.

There is a cycle in a linked list if there is some node 
in the list that can be reached again by continuously 
following the next pointer. Internally, pos is used to 
denote the index of the node that tail's next pointer 
is connected to (0-indexed). It is -1 if there is no 
cycle. Note that pos is not passed as a parameter.

Do not modify the linked list.

 

Example 1:


Input: head = [3,2,0,-4], pos = 1
Output: tail connects to node index 1
Explanation: There is a cycle in the linked list, where 
tail connects to the second node.
Example 2:


Input: head = [1,2], pos = 0
Output: tail connects to node index 0
Explanation: There is a cycle in the linked list, where
 tail connects to the first node.
Example 3:


Input: head = [1], pos = -1
Output: no cycle
Explanation: There is no cycle in the linked list.
 */
public class Start {
    public static Node firstNode(Node head) {
        // Initialize a slow and fast
        // pointers to the head of the list
        Node slow = head;
        Node fast = head;

        // Phase 1: Detect the loop
        while (fast != null && fast.next != null) {
            // Move slow one step
            slow = slow.next;

            // Move fast two steps
            fast = fast.next.next;

            // If slow and fast meet,
            // a loop is detected
            if (slow == fast) {
                // Reset the slow pointer
                // to the head of the list
                slow = head;

                // Phase 2: Find the first node of the loop
                while (slow != fast) {
                    // Move slow and fast one step
                    // at a time
                    slow = slow.next;
                    fast = fast.next;

                    // When slow and fast meet again,
                    // it's the first node of the loop
                }

                // Return the first node of the loop
                return slow;
            }
        }

        // If no loop is found, return null
        return null;
    }

    public static void main(String[] args) {
        // Create a sample linked list with a loop
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        node1.next = node2;
        Node node3 = new Node(3);
        node2.next = node3;
        Node node4 = new Node(4);
        node3.next = node4;
        Node node5 = new Node(5);
        node4.next = node5;

        // Make a loop from node5 to node2
        node5.next = node2;

        // Set the head of the linked list
        Node head = node1;

        // Detect the loop in the linked list
        Node loopStartNode = firstNode(head);

        if (loopStartNode != null) {
            System.out.println("Loop detected. Starting node of the loop is: " + loopStartNode.data);
        } else {
            System.out.println("No loop detected in the linked list.");
        }
    }
}
