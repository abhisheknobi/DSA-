package Step5_Strings.Lec_1;

import java.util.Arrays;

/*
 * Problem Statement: Write a function to find the longest common
 *  prefix string amongst an array of strings. If there is no 
 * common prefix, return an empty string "".

Examples
                
Example 1
Input: str = ["flower", "flow", "flight"]
Output: "fl"
Explanation: All strings in the array begin with the common prefix
 "fl".

Example 2
Input: str = ["apple", "banana", "grape", "mango"]
Output: ""
Explanation: None of the strings share a common starting sequence,
 so the result is an empty string.
            
 */
public class LongestComPrefix {
    public String optimal(String[] strs) {
        if (strs.length==0) {
      return "";
    }

    String prefix = strs[0];
    int prefixLength = prefix.length();

    for(int i=1; i<strs.length; i++) {
      String current = strs[i];
      while(prefixLength > current.length() || !prefix.equals(current.substring(0, prefixLength))) {
        prefixLength--;
        if (prefixLength==0) {
          return "";
        }
        prefix = prefix.substring(0, prefixLength);
      }
    }
    return prefix;

    }
     public String brute(String[] v) {
        // To store the result prefix
        StringBuilder ans = new StringBuilder();

        // Sort the array of strings
        Arrays.sort(v);

        // First string after sorting
        String first = v[0];

        // Last string after sorting
        String last = v[v.length - 1];

        // Compare characters of the first and last strings
        for (int i = 0; i < Math.min(first.length(), last.length()); i++) {
            // Stop if characters are different
            if (first.charAt(i) != last.charAt(i)) {
                break;
            }

            // Add matching character to result
            ans.append(first.charAt(i));
        }

        // Return the final common prefix
        return ans.toString();
    }
    
    public static void main(String[] args) {
        LongestComPrefix lcp = new LongestComPrefix();
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(lcp.optimal(strs));
    }
}
