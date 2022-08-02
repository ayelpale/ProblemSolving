package dynamicprogramming;

import java.util.HashMap;
// Day 5
public class ZeroOneKnapSack {

    static int [] P= ReadFileUtils.readLineAsIntArray(2);
    static int [] W= ReadFileUtils.readLineAsIntArray(3);
    static int maxWeight= ReadFileUtils.readLineAsInt(1);
    static HashMap <String ,Integer> memo=new HashMap<>();
    // For GFG we need pass everything as function parameters , to avoid getting TLE error for space

    public static void main(String[] args) {

        System.out.println(getMaxProfit(0,0));
    }

    private static int getMaxProfit(int currentIndex,int runningSum) {

        if (currentIndex>=W.length)
            return 0;

        String key= currentIndex+"-"+runningSum;

        if (memo.containsKey(key))
            return memo.get(key);

        int currentWeight = W[currentIndex];
        int currentProfit = P[currentIndex];


        int consider=0;
        if(runningSum+currentWeight<=maxWeight) {
            consider = currentProfit + getMaxProfit(currentIndex + 1, runningSum + currentWeight);
        }

        int notConsider=getMaxProfit(currentIndex+1,runningSum);
        memo.put(key,Math.max(consider,notConsider));
        return Math.max(consider,notConsider);
    }


}
