package Step3.Easy;

public class Consecutive1 {
    public static int maxConsecutive(int arr[]){
        int n=arr.length;
        int max=0;
        int count=0;
        for(int i=0;i<n;i++){
            if(arr[i]==1){
                    count++;
                    max=Math.max(max,count);
            }
                    else
                    count=0;
    }
    return max;
}
    public static void main(String[] args) {
        int arr[]={1,1,0,0,1,1,1,0,1};

    }
    
}
