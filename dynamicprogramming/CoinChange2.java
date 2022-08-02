package dynamicprogramming;

// Day 6
// https://leetcode.com/problems/coin-change-2/
//518. Coin Change 2
public class CoinChange2 {

    public static void main(String[] args) {

        System.out.println(change(10,new int[] {10}));
    }

    public static int change(int amount, int[] coins) {

        int [][] memo = new int[coins.length][amount+1];

        for(int i=0;i<coins.length;i++)
        {
            for(int j=0;j<amount+1;j++) {
                memo[i][j]=-1;
            }
        }

        return countWaysRecursive(0,amount,coins,memo);
    }

    public static int countWaysRecursive(int currentIndex,int amount, int[] coins,int [][] memo ) {
        if(amount==0)
            return 1;

        if(currentIndex==coins.length)
            return 0;

        if(memo[currentIndex][amount]!=-1)
            return memo[currentIndex][amount];

        int consider=0;
        if(coins[currentIndex]<=amount)
            consider=countWaysRecursive(currentIndex,amount-coins[currentIndex],coins,memo);

        int notConsider =countWaysRecursive(currentIndex+1,amount,coins,memo);

        memo[currentIndex][amount]=consider+notConsider;
        return memo[currentIndex][amount];
    }
}
