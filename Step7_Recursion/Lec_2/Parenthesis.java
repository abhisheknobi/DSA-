package Step7_Recursion.Lec_2;

import java.util.ArrayList;
import java.util.List;

public class Parenthesis {
     public static void back(String s,int open,int closed,int n,List<String> res){
        if(s.length()==2*n){
        res.add(s);
        return;
        }
        if(open<n)
        back(s+"(",open+1,closed,n,res);
        if(open>closed){
            back(s+")",open,closed+1,n,res);
        }
    }
    public static List<String> optimal(int n) {
        List<String> res=new ArrayList<>();
        back("",0,0,n,res);
        return res;
    }

   //brute
    public boolean isValid(String s) {
        int balance = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') balance++;
            else balance--;
            if (balance < 0) return false;
        }
        return balance == 0;
    }

    public void generateAll(String curr, int n, List<String> res) {
        if (curr.length() == 2 * n) {
            if (isValid(curr)) res.add(curr);
            return;
        }
        generateAll(curr + "(", n, res);
        generateAll(curr + ")", n, res);
    }

    public List<String> brute(int n) {
        List<String> res = new ArrayList<>();
        generateAll("", n, res);
        return res;
    }

    public static void main(String[] args) {
        List<String> result=optimal(3);
        for(String str:result){
            System.out.println(str);
        }
    }
    
}
