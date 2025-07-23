package Step2;

public class MergeSort {
    static void printArray(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    static void merge(int arr[],int l, int mid, int h){
        int n1=mid-l+1;
        int n2=h-mid;
        int L[]=new int[n1];
        int R[]=new int[n2];
        for(int i=0;i<n1;i++){
            L[i]=arr[l+i];
        }
        for(int j=0;j<n2;j++){
            R[j]=arr[mid+1+j];
        }
        int i=0,j=0,k=l;
        while(i<n1 && j<n2){
            if(L[i]<=R[j]){
                arr[k]=L[i];
                i++;
            }else{
                arr[k]=R[j];
                j++;
            }
            k++;
        }
        while(i<n1){
            arr[k]=L[i];
            i++;
            k++;
        }
        while(j<n2){
            arr[k]=R[j];
            j++;
            k++;
        }
    }

    static void Merge_sort(int arr[], int l, int h){
        if(l>=h)
        return;
        int mid=(l+h)/2;
        Merge_sort(arr,l,mid);
        Merge_sort(arr, mid+1, h);
        merge(arr,l,mid,h);
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 8, 1, 9};
        System.out.println("Before Merge Sort:");
        printArray(arr);
        Merge_sort(arr, 0, arr.length - 1);
        System.out.println("After Merge Sort:");
        printArray(arr);

    }
    
}
