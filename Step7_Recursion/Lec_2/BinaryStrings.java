package Step7_Recursion.Lec_2;

import java.util.ArrayList;

/*
 * Problem Statement: Given an integer n, return all binary strings 
 * of length n that do not contain consecutive 1s. Return the result
 *  in lexicographically increasing order.

A binary string is a string consisting only of characters '0' and '1'.

Examples
Example 1:
Input: n = 3  
Output: ["000", "001", "010", "100", "101"]  
Explanation: All binary strings of length 3 that do not contain consecutive 1s.

Example 2:
Input: n = 2  
Output: ["00", "01", "10"]  
Explanation: All binary strings of length 2 that do not contain consecutive 1s.
 */
public class BinaryStrings {
    public static void optimal(int n,String str,ArrayList<String> result){
        if(n==0){
            result.add(str);
            return;
        }

        //adding 0
        optimal(n-1,str+"0",result);

        //adding 1 only if last character is 0
        if(str.length()==0 || str.charAt(str.length()-1)=='0'){
            optimal(n-1,str+"1",result);
        }
    }
    public static void main(String[] args) {
        ArrayList<String> result= new ArrayList<>();
        optimal(3, "", result);

        for(String str:result){
            System.out.println(str);
        }

    }
    
    
}
