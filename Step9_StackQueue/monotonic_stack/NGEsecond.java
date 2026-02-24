package Step9_StackQueue.monotonic_stack;

/*
Given a circular integer array nums (i.e., the next element of 
nums[nums.length - 1] is nums[0]), return the next greater number 
for every element in nums.

The next greater number of a number x is the first greater number 
to its traversing-order next in the array, which means you could 
search circularly to find its next greater number. If it doesn't 
exist, return -1 for this number.

 

Example 1:

Input: nums = [1,2,1]
Output: [2,-1,2]
Explanation: The first 1's next greater number is 2; 
The number 2 can't find next greater number. 
The second 1's next greater number needs to search circularly, which
 is also 2.
Example 2:

Input: nums = [1,2,3,4,3]
Output: [2,3,4,-1,4]
 */
  import java.util.*;
public class NGEsecond {
     public int[] brute(int[] arr) {
        int n = arr.length;

        // To store the next greater elements
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        // Traverse each element to find its next greater
        for (int i = 0; i < n; i++) {
            int currEle = arr[i];

            // Look ahead in circular manner
            for (int j = 1; j < n; j++) {
                int ind = (i + j) % n;

                if (arr[ind] > currEle) {
                    ans[i] = arr[ind];
                    break;
                }
            }
        }

        return ans;
    }
  



    // Function to find the next greater element for each element in the array
    public static int[] optimal(int[] arr) {
        int n = arr.length;

        // To store the next greater elements
        int[] ans = new int[n];

        // Stack to help find next greater elements in reverse traversal
        Stack<Integer> st = new Stack<>();

        // Traverse the array twice in reverse to simulate circular array
        for (int i = 2 * n - 1; i >= 0; i--) {
            int ind = i % n;
            int currEle = arr[ind];

            // Pop all elements from stack that are less than or equal to current
            while (!st.isEmpty() && st.peek() <= currEle) {
                st.pop();
            }

            // Only fill result in the first pass (i < n)
            if (i < n) {
                if (st.isEmpty()) {
                    ans[ind] = -1;
                } else {
                    ans[ind] = st.peek();
                }
            }

            // Push current element to stack
            st.push(currEle);
        }

        return ans;
    }



    public static void main(String[] args) {
        int[] arr = {5, 7, 1, 7, 6, 0};

        // Call the function
        int[] ans = optimal(arr);

        System.out.print("The next greater elements are: ");
        for (int num : ans) {
            System.out.print(num + " ");
        }
    }
}

