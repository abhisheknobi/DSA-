package Step7_Recursion.Lec_2;

import java.util.ArrayList;
import java.util.List;
/*
 * Given an array of distinct integers and a target, you
 *  have to return the list of all unique combinations 
 * where the chosen numbers sum to target. You may return
 *  the combinations in any order.

The same number may be chosen from the given array an unlimited
 number of times. Two combinations are unique if the frequency 
 of at least one of the chosen numbers is different.

It is guaranteed that the number of unique combinations that sum 
up to target is less than 150 combinations for the given input.

Examples:

Example 1:

Input: array = [2,3,6,7], target = 7

Output: [[2,2,3],[7]]

Explanation: 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that
 2 can be used multiple times.
             7 is a candidate, and 7 = 7.
             These are the only two combinations.

Example 2:

Input: array = [2], target = 1

Output: []

Explaination: No combination is possible.
 */

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> current= new ArrayList<>();
        helper(candidates,target,0,current,res);
        return res;
    }

    public void helper(int candidates[],int target,int index,List<Integer> current,List<List<Integer>> res){
        if(index==candidates.length){
        if(target==0){
        res.add(new ArrayList<>(current));
        }
        return;
        }

        if(candidates[index]<=target){
            current.add(candidates[index]);
        helper(candidates,target-candidates[index],index,current,res);
        
        current.remove(current.size()-1);
        }

        helper(candidates,target,index+1,current,res);
    
    }
    public static void main(String[] args) {
        CombinationSum obj=new CombinationSum();
        int candidates[]= {2,3,6,7};
        int target=7;
        List<List<Integer>> result=obj.combinationSum(candidates, target);

        for(List<Integer> list:result){
            System.out.println(list);
        }
    }
}
    

