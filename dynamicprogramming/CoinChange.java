package dynamicprogramming;

public class CoinChange {

    public static void main(String[] args) {

        System.out.println(change(3,new int[] {2}));
    }

    public static int change(int amount, int[] coins) {

        int [][] memo = new int[coins.length][amount+1];

        for(int i=0;i<coins.length;i++)
        {
            for(int j=0;j<amount+1;j++) {
                memo[i][j]=-1;
            }
        }
        if(amount==0)
            return 0;
        int min=countWaysRecursive(0,amount,coins,memo);
        if(min==Integer.MAX_VALUE-1 || min==0)
            return -1;
        return  min ;
    }

    public static int countWaysRecursive(int currentIndex,int amount, int[] coins,int [][] memo ) {
        if(amount==0 || amount<0)
            return 0;

        if(currentIndex==coins.length)
            return Integer.MAX_VALUE-1;

        if(memo[currentIndex][amount]!=-1)
            return memo[currentIndex][amount];

        int consider=Integer.MAX_VALUE-1; // Dont forget to initialize variables
        if(coins[currentIndex]<=amount)
            consider=1+countWaysRecursive(currentIndex,amount-coins[currentIndex],coins,memo);

        int notConsider=countWaysRecursive(currentIndex+1,amount,coins,memo);

        memo[currentIndex][amount]=Math.min(consider,notConsider);
        return Math.min(consider,notConsider) ;
    }
}
