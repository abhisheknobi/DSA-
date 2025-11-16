package Step5_Strings;

import java.util.ArrayList;
import java.util.List;
/*
 * Problem Statement: Given a string s, representing a large integer,
 *  the task is to return the largest-valued odd integer (as a 
 * string) that is a substring of the given string s.
The number returned should not have leading zero's. But the given
 input string may have leading zero.

Examples
                
Example 1
Input: s = "5347"
Output: "5347"
Explanation: The odd numbers formed by the given string are → 5,
 3, 53, 347, 5347. The largest odd number without leading zeroes 
 is 5347.

Example 2
Input: s = "0214638"
Output: "21463"
Explanation: The odd numbers formed by the string are → 1, 3,
 21, 63, 463, 1463, 21463. We can't use numbers starting with 
 0, so the largest valid odd number is 21463.
 */
public class Odd {
     public static String optimal(String num) {
       int ind = -1;

        // Find the last odd digit in the string
        int i;
        for (i = num.length() - 1; i >= 0; i--) {
            if ((num.charAt(i) - '0') % 2 == 1) {
                ind = i;
                break;
            }
        }

        // Return empty string if no odd digit was found
        if (ind == -1) return "";

        // Skip leading zeroes up to the odd digit
        i = 0;
        while (i <= ind && num.charAt(i) == '0') i++;

        // Return substring from first non-zero to odd digit
        return num.substring(i, ind + 1);
    }


    public String brute(String num) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < num.length(); i++) {
    for (int j = i+1; j <= num.length(); j++) {
        list.add(num.substring(i, j));
    }
}
int max=0;
        for(int i=0;i<list.size();i++){
            int n=Integer.parseInt(list.get(i));
            if(n%2==1)
            max=Math.max(n,max);    
        }
        if(max==0){
            return "";
        }
        return Integer.toString(max);
    }
    public static void main(String[] args) {
        String s = "020468";
        System.out.println(optimal(s));
        
    }
}
    

