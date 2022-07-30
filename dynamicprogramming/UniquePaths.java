package dynamicprogramming;
//https://leetcode.com/problems/unique-paths/
// 62- Unique Paths
public class UniquePaths {

    public static void main(String[] args) {

        System.out.println(uniquePaths(3,100));
    }

    public static int uniquePaths(int m, int n) {

        return uniquePathsRecursiveDP(0,0,m,n , new int [m][n]);
    }

    public static int uniquePathsRecursiveDP(int i, int j, int m, int n, int [][] memo) {

        if(i==m-1 && j==n-1)
            return 1;

        if(i>=m || j>=n)
            return 0;

        if(memo[i][j]!=0)
            return memo[i][j];

        int down= uniquePathsRecursiveDP(i+1,j,m,n,memo);
        int right= uniquePathsRecursiveDP(i,j+1,m,n,memo);

        memo[i][j]=down+right;

        return down+right;
    }

}
