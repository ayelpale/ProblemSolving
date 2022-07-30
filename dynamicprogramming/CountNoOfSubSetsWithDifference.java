package dynamicprogramming;

// Asked in GOOGLE

// https://www.geeksforgeeks.org/count-of-subsets-with-given-difference/#:~:text=Given%20an%20array%20arr%5B%5D,equal%20to%20the%20given%20difference.

import java.util.HashMap;

public class CountNoOfSubSetsWithDifference {

    static private HashMap<String ,Integer> memo  = new HashMap<>();
    public static void main(String[] args) {

        // Math required targetSum = (S-difference)/2  , S = total sum
        System.out.println(noOfSubSets(3,new int []  {2,4,1,3}));
    }

    private static int noOfSubSets(int targetSum, int[] nums) {

        return targetSumRecursive(0,targetSum,nums,0);
    }

    private static int targetSumRecursive(int i, int targetSum, int[] nums,int sum) {
        if (sum==targetSum)
            return 1;

        if(i==nums.length)
            return 0;
        String key=i+"-"+sum;
        if(memo.containsKey(key))
            return memo.get(key);

        int consider=targetSumRecursive(i+1,targetSum,nums,sum+nums[i]);
        int notConsider=targetSumRecursive(i+1,targetSum,nums,sum);

        memo.put(key,consider+notConsider);
        return consider+notConsider;
    }


}
