package dynamicprogramming;

import java.util.HashMap;

//1. 70 - Climbing stairs
// https://leetcode.com/problems/climbing-stairs/
public class ClimbingStairs {

    public static void main(String[] args) {
       System.out.println(climbStairs(45));
    }

    public static int climbStairs(int n) {
        return climbStairsRecursiveDP(0,n, new HashMap<Integer,Integer>());
    }

    private static int climbStairsRecursive(int currentStep, int targetStep) {
        // Recursive solution without memoization
        if(currentStep==targetStep)
            return 1;
        if(currentStep>targetStep)
            return 0;
        int oneJum= climbStairsRecursive(currentStep+1,targetStep);
        int twoJumps= climbStairsRecursive(currentStep+2,targetStep);
        return oneJum+twoJumps;
    }

    // Dynamic Programming Approach
    private static int climbStairsRecursiveDP(int currentStep, int targetStep, HashMap<Integer,Integer> memo) {
        if(currentStep==targetStep)
            return 1; // base case when step is reached at targetStep
        if(currentStep>targetStep)
            return 0; // base case when step is greater than targetStep, for laststep when currentStep+2 is called

        // int currentKey = currentStep
        if(memo.containsKey(currentStep))
            return memo.get(currentStep); // if found in cache return from it

        int oneJum= climbStairsRecursiveDP(currentStep+1,targetStep,memo);
        int twoJumps= climbStairsRecursiveDP(currentStep+2,targetStep,memo);

        memo.put(currentStep,oneJum+twoJumps); // cache the overlapping sub problems

        return oneJum+twoJumps;
    }
}
