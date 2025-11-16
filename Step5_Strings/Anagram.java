package Step5_Strings;

import java.util.Arrays;

/*
 * Problem Statement: Given two strings, check if two strings
 *  are anagrams of each other or not.

Examples:

Example 1:
Input: CAT, ACT
Output: true
Explanation: Since the count of every letter of both strings are equal.

Example 2:
Input: RULES, LESRT 
Output: false
Explanation: Since the count of U and T  is not equal in both strings.
 */
public class Anagram {
     public static boolean brute(String s, String t) {
        if(s.length()!=t.length())
        return false;
        char[] one=s.toCharArray();
        char[] two=t.toCharArray();
        Arrays.sort(one);
        Arrays.sort(two);

        for(int i=0;i<one.length;i++){
            if(one[i]!=two[i])
            return false;
        }
        return true;
    }
    public static boolean optimal(String s, String t) {
        if (s.length() != t.length())
            return false;

        int[] freq = new int[256];

for (int i = 0; i < s.length(); i++) {
    freq[s.charAt(i)]++;
    freq[t.charAt(i)]--;
}


for (int i = 0; i < 256; i++) {
    if (freq[i] != 0)
        return false;
}
return true;
    }


    public static void main(String[] args) {
        String s="CAT";
        String t="ACT";
        System.out.println(optimal(s, t));
        
    }
}
