package Step9_StackQueue.basics;

/*
Implement Min Stack : O(2N) and O(N) Space Complexity



4

Problem Statement: Design a stack that supports the following operations
 in constant time: push, pop, top, and retrieving the minimum element.

Implement the OptimalMinStack class:

MinStack(): Initializes the stack object.
void push(int val): Pushes the element val onto the stack.
void pop(): removes the element on the top of the stack.
int top(): gets the top element of the stack.
int getMin(): retrieves the minimum element in the stack.

Examples
Example 1:
Input:
 ["MinStack", "push", "push", "push", "getMin", "pop", "top", "getMin"]  
[ [], [-2], [0], [-3], [ ], [ ], [ ], [ ] ]  
Output:
 [null, null, null, null, -3, null, 0, -2]  
Explanation:
  
MinStack minStack = new MinStack();  
- minStack.push(-2);  
- minStack.push(0);  
- minStack.push(-3);  
- minStack.getMin(); // returns -3  
- minStack.pop();  
- minStack.top(); // returns 0  
- minStack.getMin(); // returns -2  

Example 2:
Input:
 ["MinStack", "push", "push", "getMin", "push", "pop", "getMin", "top"]  
[ [ ], [5], [1], [ ], [3], [ ], [ ], [ ] ]  
Output:
 [null, null, null, 1, null, null, 1, 1]  
Explanation:
  
MinStack minStack = new MinStack();  
- minStack.push(5);  
- minStack.push(1);  
- minStack.getMin(); // returns 1  
- minStack.push(3);  
- minStack.pop();  
- minStack.getMin(); // returns 1  
- minStack.top(); // returns 1 */

import java.util.*;

// Class to implement Minimum Stack brute force approach
public class MinStack {
    // Initialize a stack
    private Stack<int[]> st;

    // Empty Constructor
    public MinStack() {
        st = new Stack<>();
    }

    // Method to push a value in stack
    public void push(int value) {
        // If stack is empty
        if (st.isEmpty()) {
            // Push current value as minimum
            st.push(new int[]{value, value});
            return;
        }

        // Update the current minimum
        int mini = Math.min(getMin(), value);

        // Add the pair to the stack
        st.push(new int[]{value, mini});
    }

    // Method to pop a value from stack
    public void pop() {
        // Using in-built pop method
        st.pop();
    }

    // Method to get the top of stack
    public int top() {
        // Return the top value
        return st.peek()[0];
    }

    // Method to get the minimum in stack
    public int getMin() {
        // Return the minimum
        return st.peek()[1];
    }
}

class Main {
    public static void main(String[] args) {
        MinStack s = new MinStack();

        // Function calls
        s.push(-2);
        s.push(0);
        s.push(-3);
        System.out.print(s.getMin() + " ");
        s.pop();
        System.out.print(s.top() + " ");
        s.pop();
        System.out.print(s.getMin());
    }
}

// Class to implement Minimum Stack optimal approach
class OptimalMinStack {
    private Stack<Integer> st;
    private int mini;

    // Empty Constructor
    public OptimalMinStack() {
        st = new Stack<>();
    }

    // Method to push a value in stack
    public void push(int value) {
        // If stack is empty
        if (st.isEmpty()) {
            // Update the minimum value
            mini = value;

            // Push current value as minimum
            st.push(value);
            return;
        }

        // If the value is greater than the minimum
        if (value > mini) {
            st.push(value);
        } else {
            // Add the modified value to stack
            st.push(2 * value - mini);
            // Update the minimum
            mini = value;
        }
    }

    // Method to pop a value from stack
    public void pop() {
        // Base case
        if (st.isEmpty()) return;

        // Get the top
        int x = st.pop();

        // If the modified value was added to stack
        if (x < mini) {
            // Update the minimum
            mini = 2 * mini - x;
        }
    }

    // Method to get the top of stack
    public int top() {
        // Base case
        if (st.isEmpty()) return -1;

        // Get the top
        int x = st.peek();

        // Return top if minimum is less than the top
        if (mini < x) return x;

        // Otherwise return mini
        return mini;
    }

    // Method to get the minimum in stack
    public int getMin() {
        // Return the minimum
        return mini;
    }
}

