package Step7_Recursion.Lec_2;

/*
 * Problem Statement: Given an array print all the sum of the subset 
 * generated from it, in the increasing order.

Examples

Input: N = 3, arr[] = {5,2,1}
Output: 0,1,2,3,5,6,7,8
Explanation: We have to find all the subset’s sum and print them.in this
 case the generated subsets are [ [], [1], [2], [2,1], [5], [5,1], [5,2].
  [5,2,1],so the sums we get will be  0,1,2,3,5,6,7,8

Input: N=3,arr[]= {3,1,2}
Output: 0,1,2,3,3,4,5,6
Explanation: We have to find all the subset’s sum and print them.in this
 case the generated subsets are [ [], [1], [2], [2,1], [3], [3,1], [3,2].
  [3,2,1],so the sums we get will be  0,1,2,3,3,4,5,6
 */

 import java.util.ArrayList;
public class SubSetSum {

    public static void helper(int []arr,int index,int sum,ArrayList<Integer> res){
        if(index==arr.length){
            res.add(sum);
            return;
        }
        //pick the element
        helper(arr, index+1,sum+arr[index],res);

        //not pick the element
        helper(arr, index+1,sum,res);


    }

    public static void main(String[] args) {    
        int arr[]={3,1,2};
        ArrayList<Integer> res=new ArrayList<>();
        helper(arr,0,0,res);
        res.sort(null);
        for(int sum:res){
            System.out.print(sum+" ");
        }
        
    }


    
}
