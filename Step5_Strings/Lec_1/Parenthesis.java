package Step5_Strings.Lec_1;
/* 
Problem Statement: A valid parentheses string is defined by the following rules:

It is the empty string "".
If A is a valid parentheses string, then so is "(" + A + ")".
If A and B are valid parentheses strings, then A + B is also valid.

A primitive valid parentheses string is a non-empty valid string that
 cannot be split into two or more non-empty valid parentheses strings.

Given a valid parentheses string s, your task is to remove the 
outermost parentheses from every primitive component of s and 
return the resulting string.

Examples
Example 1:
Input: s = "((()))"
Output: "(())"
Explanation: The input string is a single primitive: "((()))".  
Removing the outermost layer yields: "(())".

Example 2:
Input: s = "()(()())(())"
Output: "(()())()"
Explanation: Primitive decomposition: "()" + "(()())" + "(())"  
After removing outermost parentheses: "" + "()()" + "()"
Final result: "(()())()".

 */


/*Intuition 

---

This problem can be solved using a stack-based approach where
 the goal is to remove the outermost parentheses of each 
 primitive substring. The idea is that a primitive substring
  starts when the stack goes from empty to non-empty and ends
   when it becomes empty again. While iterating through the 
   string, whenever we see an opening parenthesis `(` and the
    stack is empty, it means this is the outermost parenthesis
     of a primitive, so we push it to the stack but do NOT add
      it to the answer. For any other `(` (when the stack is not
       empty), we push it and also append it to the answer because
        it is not outermost. For a closing parenthesis `)`, we 
        first pop from the stack; if the stack becomes empty after
         popping, that means this is the outermost closing 
         parenthesis of the primitive, so we skip adding it to the
          answer. Otherwise, if the stack is still not empty after
           popping, we append this `)` to the answer. This works 
           because in a valid parentheses string, a primitive
            substring always starts when the stack goes from 
            0 → 1 and ends when it goes from 1 → 0. Therefore, by 
            skipping exactly these transitions, we effectively 
            remove the outermost parentheses and keep only the 
            inner content. This approach runs in O(n) time and 
            uses O(n) space due to the stack.

 */

 //This can be simplified further by using a counter instead of a stack
 
public class Parenthesis {
    public String removeOuterParentheses(String S) {
        StringBuilder s = new StringBuilder();
        int opened = 0;
        for (char c : S.toCharArray()) {
            if (c == '(' && opened++ > 0)
                s.append(c);
            if (c == ')' && opened-- > 1)
                s.append(c);
        }
        return s.toString();
    }

    public static void main(String[] args) {
        Parenthesis p = new Parenthesis();
        String s = "(()())(())(()(()))";
        System.out.println(p.removeOuterParentheses(s));
    }

}
