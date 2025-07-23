package Step3.Medium;

public class RearrangePosNeg {
    public static int[] rearrange(int arr[]){
        int ans[]=new int[arr.length];
        int pos=0, neg=1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>=0){
                ans[pos]=arr[i];
                pos+=2;
            }else{
                ans[neg]=arr[i];
                neg+=2;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {1, -2, 3, -4, 5, -6, 7, -8};
        System.out.println("Before Rearranging:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
        int ans[]=new int [arr.length];
        ans=rearrange(arr);
        
        System.out.println("After Rearranging:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
    
}
