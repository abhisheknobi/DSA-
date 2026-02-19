package Step7_Recursion.Lec_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/*
 * iven an integer array nums that may contain duplicates, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 
 */
public class SubsetSum2 { 
    //brute force using set to avoid duplicates
    public void helper(int []arr,int index,List<Integer> curr,Set<List<Integer>> res){
        if(index==arr.length){
            res.add(new ArrayList<>(curr));
            return;
        }

        curr.add(arr[index]);
        helper(arr,index+1,curr,res);
        curr.remove(curr.size()-1);   
        helper(arr,index+1,curr,res);
    }
    public List<List<Integer>> brute(int[] nums) {
        Set<List<Integer>> res= new HashSet<>();
        List<Integer> curr=new ArrayList<>();

        helper(nums,0,curr,res);
        List<List<Integer>> fin=new ArrayList<>();
        fin.addAll(res);
        return fin;
    }
    public void helper2(int []arr,int index,List<Integer> curr,List<List<Integer>> res){
        res.add(new ArrayList<>(curr));
        
        for(int i=index;i<arr.length;i++){
            if (i != index && arr[i] == arr[i - 1]) continue;
            
        curr.add(arr[i]);
        helper2(arr,i+1,curr,res);
        curr.remove(curr.size()-1);   
        }
    }
    public List<List<Integer>> optimal(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res= new ArrayList<>();
        List<Integer> curr=new ArrayList<>();

        helper2(nums,0,curr,res);
        return res;
    }

    public static void main(String[] args) {
        int arr[]={1,2,2};
        SubsetSum2 obj=new SubsetSum2();
        List<List<Integer>> res=obj.brute(arr);
        System.out.println(res);
        
    }
    
}
