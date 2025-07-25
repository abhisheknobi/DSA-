package Step3.Medium;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class RightLeader {
    public static List<Integer> rightleader(int arr[]){
        int n=arr.length;
        List<Integer> ans=new ArrayList<>();
       

        for(int i=0;i<n;i++){
             boolean leader=true;
            for(int j=i+1;j<n;j++){
                if(arr[j]>arr[i])
                leader=false;
                break;
            }
            if(leader){
                ans.add(arr[i]);
            
            }
        }
        return ans;
    }

    public static List<Integer> optimized(int arr[]){
        int n=arr.length;
        List<Integer> ans=new ArrayList<>();
        int max=Integer.MIN_VALUE;
        for(int i=n-1;i>=0;i--){
            if(arr[i]>max){
                ans.add(arr[i]);
                max=arr[i];
            }
        }
        Collections.reverse(ans);
        return ans; // Reverse to maintain order
    }
    public static void main(String[] args) {
        int arr[]={5,4,8,1,2};
        List<Integer> ans= rightleader(arr);
        List<Integer> ans2=optimized(arr);
        System.out.println("The right leader is: " + ans2);
    }
    
}
