package dynamicprogramming;

public class MaximumSubArray {

    public static void main(String[] args) {

        System.out.println(maxSubArray(new int [] {5,4,-1,7,8}));
    }
    public static int maxSubArray(int[] nums) {

        return maxSubArrayRecursive(nums,0);
    }

    public static int maxSubArrayRecursive(int [] nums,int i)
    {
        if(i==nums.length)
            return 0;

        int consider=nums[i]+maxSubArrayRecursive(nums,i+1);
        int not_consider=maxSubArrayRecursive(nums,i+1);

        System.out.println(consider + " " +not_consider+" "+nums[i]);
        return Math.max(consider,not_consider);
    }
}
