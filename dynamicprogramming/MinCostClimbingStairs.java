package dynamicprogramming;

import java.util.HashMap;

// 746. Min Cost Climbing Stairs
// https://leetcode.com/problems/min-cost-climbing-stairs/
public class MinCostClimbingStairs {

    public static void main(String[] args) {

        System.out.println(minCostClimbingStairs(new int[] {1,100,1,1,1,100,1,1,100,1}));
    }

    public static  int minCostClimbingStairs(int[] cost) {

        HashMap<Integer,Integer> memo = new HashMap<>();
        return Math.min(minCostClimbingStairsRecursiveDP(0,cost, memo),memo.get(1));
    }

    public static  int minCostClimbingStairsRecursive(int currentStep,int[] cost) {

        if(currentStep==cost.length)
            return 0;
        if(currentStep>cost.length)
            return 1001;

        int oneJump = cost[currentStep]+minCostClimbingStairsRecursive(currentStep+1,cost);
        int twoJump = cost[currentStep]+minCostClimbingStairsRecursive(currentStep+2,cost);

        return Math.min(oneJump,twoJump);
    }

    public static  int minCostClimbingStairsRecursiveDP(int currentStep, int[] cost, HashMap<Integer,Integer> memo) {

        if(currentStep==cost.length)
            return 0;
        if(currentStep>cost.length)
            return 1001;

        if(memo.containsKey(currentStep))
            return memo.get(currentStep);

        int oneJump = cost[currentStep]+minCostClimbingStairsRecursiveDP(currentStep+1,cost,memo);
        int twoJump = cost[currentStep]+minCostClimbingStairsRecursiveDP(currentStep+2,cost,memo);

        memo.put(currentStep,Math.min(oneJump,twoJump));

        return Math.min(oneJump,twoJump);
    }


}
