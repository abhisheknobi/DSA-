package Step3.Easy;

import java.util.HashSet;

public class RemoveDuplicates {

    static void printArray(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    static int remDup1(int arr[]){
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<arr.length;i++){
            set.add(arr[i]);
        }
        int k=0;
        for(int j:set)
        arr[k++]=j;
        for(int i=k;i<arr.length;i++){
            arr[i]=0;
        }
        return k;
    }

    static int remDup2(int arr[]){
        int n=arr.length;
        int i=0;
        for(int j=1;j<n;j++)
{
    if(arr[j]!=arr[i]){
        arr[++i]=arr[j];
    }
}
for(int k=i+1;k<n;k++){
    arr[k]=0;
}
return i+1;
    }
    public static void main(String[] args) {
        int arr[]={1,1,2,2,2,3,3};
        System.out.println("Before Removing Duplicates:");
        printArray(arr);
        System.out.println();
        int n=remDup2(arr);
        System.out.println("After Removing Duplicates:");
        printArray(arr);
        System.out.println();
        System.out.println("Number of Unique Elements: " + n);
        
    }
    
}
