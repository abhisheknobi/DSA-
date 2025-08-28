package Step1_Basics.Lecture5;

public class Palindrome {

    public static boolean pal1(String s) {
        if (s.isEmpty()) {
            return true;
        }
        int start = 0;
        int last = s.length() - 1;
        while (start <= last) {
            char currFirst = s.charAt(start);
            char currLast = s.charAt(last);
            if (!Character.isLetterOrDigit(currFirst)) {
                start++;
            } else if (!Character.isLetterOrDigit(currLast)) {
                last--;
            } else {
                if (Character.toLowerCase(currFirst) != Character.toLowerCase(currLast)) {
                    return false;
                }
                start++;
                last--;
            }
        }
        return true;
    }

    public static boolean pal2(int i, String s) {// Recursive approach
        int n = s.length();
        if (i >= n / 2)
            return true;
        if (s.charAt(i) != s.charAt(n - i - 1)) {
            return false;
        }
        return pal2(i + 1, s);

    }

    public static void main(String[] args) {
        String s1 = "A man, a plan, a canal: Panama";

        String s2 = "aabbaa";
        System.out.println(pal1(s1));
        System.out.println(pal2(0, s2));
    }

}
