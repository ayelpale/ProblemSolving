package dynamicprogramming;

import java.util.HashMap;

// 198 - House Robber
// https://leetcode.com/problems/house-robber/
public class HouseRobber {

    public static void main(String[] args) {
        System.out.println(rob(new int [] {2,7,9,3,1}));
    }
    public static int rob(int[] nums) {
        HashMap<Integer,Integer> memo = new HashMap<>();
        return robRecursiveDP(0,nums,memo);
    }

    public static int robRecursive(int currenthouse,int[] nums) {
        if(currenthouse==nums.length)
            return 0;

        if(currenthouse>nums.length)
            return 0;

        int rob = nums[currenthouse]+robRecursive(currenthouse+2,nums);
        int dontRob = robRecursive(currenthouse+1,nums);

        return Math.max(rob,dontRob);
    }

    public static int robRecursiveDP(int currenthouse, int[] nums, HashMap<Integer,Integer> memo) {
        if(currenthouse==nums.length)
            return 0;

        if(currenthouse>nums.length)
            return 0;

        if(memo.containsKey(currenthouse))
            return memo.get(currenthouse);

        int rob = nums[currenthouse]+robRecursiveDP(currenthouse+2,nums,memo);
        int dontRob = robRecursiveDP(currenthouse+1,nums,memo);

        memo.put(currenthouse,Math.max(rob,dontRob)); // cache the overlapping sub problems

        return Math.max(rob,dontRob);
    }


}
