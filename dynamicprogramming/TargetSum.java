package dynamicprogramming;

import java.util.HashMap;

// https://leetcode.com/problems/target-sum/
// 494. Target Sum
// Day 4
public class TargetSum {

    static private HashMap <String ,Integer> memo  = new HashMap<>();
    public static void main(String[] args) {

        System.out.println(targetSum(3,new int []  {1,1,1,1,1}));
    }

    private static int targetSum(int targetSum, int[] nums) {

        return targetSumRecursive(0,targetSum,nums,0);
    }

    private static int targetSumRecursive(int i, int targetSum, int[] nums,int sum) {
        if(i==nums.length && sum==targetSum)
            return 1;

        if(i==nums.length)
            return 0;
        String key=i+"-"+sum;
        if(memo.containsKey(key))
            return memo.get(key);

        int positiveCount=targetSumRecursive(i+1,targetSum,nums,sum+nums[i]);
        int negativeCount=targetSumRecursive(i+1,targetSum,nums,sum-nums[i]);

        memo.put(key,positiveCount+negativeCount);
        return positiveCount+negativeCount;
    }


}
