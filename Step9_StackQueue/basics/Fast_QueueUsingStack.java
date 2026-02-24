package Step9_StackQueue.basics;

import java.util.*;
/*
Using two Stacks where push operation is O(1)
 */
class Fast_QueueUsingStack {
    private Stack<Integer> input, output;

    // Initialize your data structure here
    public Fast_QueueUsingStack() {
        input = new Stack<>();
        output = new Stack<>();
    }

    // Push element x to the back of queue
    public void push(int x) {
        input.push(x);
    }

    // Removes the element from in front of queue and returns that element
    public int pop() {
        // Shift input to output if output is empty
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }

        // If queue is still empty, return -1 (or throw an error if preferred)
        if (output.isEmpty()) {
            System.out.println("Queue is empty, cannot pop.");
            return -1;
        }

        return output.pop();
    }

    // Get the front element
    public int peek() {
        // Shift input to output if output is empty
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }

        // If queue is still empty, return -1 (or throw an error if preferred)
        if (output.isEmpty()) {
            System.out.println("Queue is empty, cannot peek.");
            return -1;
        }

        return output.peek();
    }

    // Returns true if the queue is empty, false otherwise
    public boolean isEmpty() {
        return input.isEmpty() && output.isEmpty();
    }
}

class Main {
    public static void main(String[] args) {
        Fast_QueueUsingStack q = new Fast_QueueUsingStack();
        q.push(3);
        q.push(4);
        System.out.println("The element popped is " + q.pop());
        q.push(5);
        System.out.println("The front of the queue is " + q.peek());
        System.out.println("Is the queue empty? " + (q.isEmpty() ? "Yes" : "No"));
        System.out.println("The element popped is " + q.pop());
        System.out.println("The element popped is " + q.pop());
        System.out.println("Is the queue empty? " + (q.isEmpty() ? "Yes" : "No"));
    }
}

