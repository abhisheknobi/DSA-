package Step1.Lecture5;

public class Palindrome {
    
    public static boolean pal1(int left, String s) {
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean pal2(int i,String s){//Recursive approach
        int n=s.length();
        if(i>=n/2)
        return true;
        if(s.charAt(i)!=s.charAt(n-i-1)){
            return false;
        }
        return pal2(i+1,s);

    }
    public static void main(String[] args) {
        String s1="naman";
        String s2="aabbaa";
        System.out.println(pal1(0,s1));
        System.out.println(pal2(0,s2));
    }
    
}
