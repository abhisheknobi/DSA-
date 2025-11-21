package Step7_Recursion;

public class Atoi {
      public int helper(String s, int sign, int i, long num) {
        if (i >= s.length() || !Character.isDigit(s.charAt(i))) {
            // Apply sign and clamp final result
            if (num > Integer.MAX_VALUE) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            return (int)(sign * num);
        }

        num = num * 10 + (s.charAt(i) - '0');

        // Early overflow detection
        if (sign == 1 && num > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (sign == -1 && num > -(long)Integer.MIN_VALUE) return Integer.MIN_VALUE;

        return helper(s, sign, i + 1, num);
    }

    public int myAtoi(String s) {
        int i = 0;
        
        // Skip whitespace
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }

        // Handle sign
        int sign = 1;
        if (i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = s.charAt(i) == '-' ? -1 : 1;
            i++;
        }

        // Start conversion
        return helper(s, sign, i, 0L);
    }
}

    

