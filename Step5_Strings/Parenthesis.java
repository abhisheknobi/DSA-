package Step5_Strings;

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
