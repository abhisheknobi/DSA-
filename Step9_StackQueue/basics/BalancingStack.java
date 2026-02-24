package Step9_StackQueue.basics;

import java.util.Stack;

/*Problem Statement: Check Balanced Parentheses. Given string str containing 
just the characters '(', ')', '{', '}', '[' and ']', check if the input 
string is valid and return true if the string is balanced otherwise return false. .

Note:
Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Examples
Example 1:
Input: str = “( )[ { } ( ) ]”
Output: True
Explanation: As every open bracket has its corresponding close bracket. 
Match parentheses are in correct order hence they are balanced.


Example 2:
Input: str = “[ ( )”
Output: False
Explanation: As ‘[‘ does not have ‘]’ hence it is not valid and will return false.

 */
public class BalancingStack {
    public static boolean isValid(String s) {
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='('|| ch=='{'|| ch=='['){
                st.push(ch);
            }
            else{
                if(st.isEmpty())
                    return false;
                char top=st.pop();
                if(ch=='('&& top!=')')
                    return false;
                if(ch=='{'&& top!='}')
                    return false;
                if(ch=='['&& top!=']')
                    return false;
            }
        }

        return st.isEmpty();
    }
 public static void main(String[] args) {
       
        String s = "()[{}()]";

        if (isValid(s))
            System.out.println("True");
        else
            System.out.println("False");
    }
    
}
