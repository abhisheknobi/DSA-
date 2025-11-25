package Step7_Recursion.Lec_2;

import java.util.ArrayList;
import java.util.List;
class PowerSet {
public static List<String> getSubsequences(String s) {
        // Length of input string
        int n = s.length();

        // Total subsequences = 2^n
        int total = 1 << n;

        // List to store all subsequences
        List<String> subsequences = new ArrayList<>();

        // Iterate over all bit masks from 0 to 2^n - 1
        for (int mask = 0; mask < total; mask++) {
            // Temporary subsequence builder
            StringBuilder subseq = new StringBuilder();

            // Check each bit position in mask
            for (int i = 0; i < n; i++) {
                // If i-th bit of mask is set, include s.charAt(i)
                if ((mask & (1 << i)) != 0) {
                    subseq.append(s.charAt(i));
                }
            }

            // Store the formed subsequence as string
            subsequences.add(subseq.toString());
        }

        // Return all generated subsequences
        return subsequences;
    }
    
     public static void helper(String s, int index, StringBuilder current, List<String> result) {
        // Base case: if index reaches string length, add current subsequence to result
        if (index == s.length()) {
            result.add(current.toString());
            return;
        }

        // Exclude current character and recurse
        helper(s, index + 1, current, result);

        // Include current character and recurse
        current.append(s.charAt(index));
        helper(s, index + 1, current, result);

        // Backtrack by removing last character
        current.deleteCharAt(current.length() - 1);
    }

    // Method to return all subsequences of string s
    public static List<String> backtrack(String s) {
        // List to store all subsequences
        List<String> result = new ArrayList<>();

        // StringBuilder to store current subsequence
        StringBuilder current = new StringBuilder();

        // Start recursion from index 0
        helper(s, 0, current, result);

        // Return list of subsequences
        return result;
    }
    public static void main(String[] args) {
        // Input string
        String s = "abc";

        // Get all subsequences
        List<String> subsequences = backtrack(s);

        // Print all subsequences
        for (String subseq : subsequences) {
            System.out.println("\"" + subseq + "\"");
        }
    } {
    }  
}
