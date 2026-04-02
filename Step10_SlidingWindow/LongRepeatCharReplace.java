package Step10_SlidingWindow;
/*
You are given a string s and an integer k. You can choose any character of the
string and change it to any other uppercase English character. You can perform
this operation at most k times.

Return the length of the longest substring containing the same letter you can get
after performing the above operations.



Example 1:

Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.
Example 2:

Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
There may exists other ways to achieve this answer too.
 */
import java.util.HashMap;
import java.util.Map;

public class LongRepeatCharReplace {
    /*intutition is to replace th elements that have the least frequency in a
    particular window that is done by subtracting the len of the window
    with the maxfreq of an element that is more in a window to get the  remaing

     */
    public static int brute(String s, int k) {
        int maxlen=0;

        for(int i=0;i<s.length();i++){
            Map<Character,Integer> mpp=new HashMap<>();
            int maxfreq=0;
            for(int j=i;j<s.length();j++){
                char ch=s.charAt(j);
                mpp.put(ch,mpp.getOrDefault(ch,0)+1);
                maxfreq=Math.max(maxfreq,mpp.getOrDefault(ch,0));
                int wind=j-i+1;
                int replacements = wind - maxfreq;

                // If replacements are within k, update maxLength
                if (replacements <= k) {
                    maxlen = Math.max(maxlen, wind);
                }
            }
        }
        return maxlen;
    }

    static int better(String s, int k){
        int l=0;
        int r=0;
        int maxlen=0;
        int maxfreq=0;
        Map<Character,Integer> mpp=new HashMap<>();
        while(r< s.length()){
            mpp.put(s.charAt(r),mpp.getOrDefault(s.charAt(r),0)+1);
            maxfreq=Math.max(maxfreq,mpp.getOrDefault(s.charAt(r),0));

            while(r-l+1-maxfreq>k){
                mpp.put(s.charAt(l),(mpp.getOrDefault(s.charAt(l),0)-1));
                l++;
            }
            maxlen=Math.max(r-l+1,maxlen);
            r++;
        }
        return maxlen;
    }

    static void main() {
       String s = "ABAB";
       int k = 2;

        String s2 = "AABABBA";
        int k2 = 1;

        System.out.println(better(s2,k2));
    }

}
