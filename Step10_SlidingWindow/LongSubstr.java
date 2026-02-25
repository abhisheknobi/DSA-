package Step10_SlidingWindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/*
Problem Statement: Given a string, S. Find the length of the
 longest substring without repeating characters.

Examples
Example 1:
Input:
 S = "abcddabac"  
Output:
 4  
Explanation:
 The longest substring with distinct characters is "abcd", which has a 
 length of 4.

Example 2:
Input:
 S = "aaabbbccc"  
Output:
 2  
Explanation:
 The longest substrings with distinct characters are "ab" and "bc", both 
 having a length of 2.
 */
public class LongSubstr {
 public static int brute(String s) {
        int n = s.length();
        int maxLen = 0;

        // Iterate through all possible starting points
        for (int i = 0; i < n; i++) {
            int[] hash = new int[256]; // For extended ASCII
            Arrays.fill(hash, 0);

            for (int j = i; j < n; j++) {
                if (hash[s.charAt(j)] == 1) break; // Found a repeat
                hash[s.charAt(j)] = 1;

                int len = j - i + 1;
                maxLen = Math.max(maxLen, len);
            }
        }
        return maxLen;
    }

    public static int better(String s) {
        int n = s.length();
        int maxLen = 0;

        // Traverse each starting index of substrings
        for (int i = 0; i < n; i++) {
            // Set to store unique characters in the current substring
            HashSet<Character> set = new HashSet<>();

            // Traverse all substrings starting at index i
            for (int j = i; j < n; j++) {
                char currChar = s.charAt(j);

                // If the character is already in the set, break the loop
                if (set.contains(currChar)) {
                    break;
                }

                // Add the current character to the set
                set.add(currChar);

                // Update the maximum length if needed
                maxLen = Math.max(maxLen, set.size());
            }
        }

        return maxLen;
    }

        public static int optimal(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int length = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)) {
                start = Math.max(start, map.get(c) + 1);
            }
            length = Math.max(length, i - start + 1);
            map.put(c, i);
        }
        return length;
    }
    public static void main(String[] args) {
        String s = "abcddabac";
        int ans = optimal(s);
        System.out.println("The length of the longest substring without repeating characters is: " + ans);
    }
    
}
