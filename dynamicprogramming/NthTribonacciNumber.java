package dynamicprogramming;


//1137. N-th Tribonacci Number
//https://leetcode.com/problems/n-th-tribonacci-number/
public class NthTribonacciNumber {
    public static void main(String[] args) {

        System.out.println(tribonacci(25 , new int[100]));
    }



    public static int tribonacci(int n, int [] memo) {

        if (n==0)
            return  0;
        if (n==1 || n==2)
            return  1;

        if(memo[n]!=0)
            return memo[n];

        int sum= tribonacci(n-1,memo)+tribonacci(n-2,memo)+tribonacci(n-3,memo);

        memo[n]=sum;
        return sum;
    }
}
