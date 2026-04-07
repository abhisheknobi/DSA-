package Step10_SlidingWindow.medium;
/*
Given a string s consisting only of characters a, b and c.

Return the number of substrings containing at least one occurrence of all these characters a, b and c.



Example 1:

Input: s = "abcabc"
Output: 10
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "abc",
 "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again).
Example 2:

Input: s = "aaacb"
Output: 3
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "aaacb", "aacb" and "acb".
Example 3:

Input: s = "abc"
Output: 1
 */
public class SubstrWithThreeChar {
    static void main() {
        String s = "aaacb";
        System.out.println(brute(s));
    }

    public static int brute(String s) {
        int n = s.length();
        int count = 0;
        for (int i = 0; i < n; i++) {
            int[] hash = new int[3];
            for (int j = i; j < n; j++) {
                hash[s.charAt(j) - 'a'] = 1;
                if (hash[0] == 1 && hash[1] == 1 && hash[2] == 1) {
                    count += n - j;
                    break;
                }
            }
        }
        return count;
    }

    public int optimal(String s) {
        int[] freq = new int[3];

        // Left pointer for the sliding window
        int left = 0;

        // Result variable to store count of valid substrings
        int res = 0;

        // Traverse the string with right pointer
        for (int right = 0; right < s.length(); right++) {
            // Increment frequency of current character
            freq[s.charAt(right) - 'a']++;

            // Shrink the window from the left while all characters are present
            while (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {
                // Count substrings from current right to end
                res += (s.length() - right);

                // Move left pointer and update frequency
                freq[s.charAt(left) - 'a']--;
                left++;
            }
        }

        return res;

    }
}
