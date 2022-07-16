package com.algo.learning;
//Leed code 576
public class OutofBoundaryPaths {
    final long mod = 1000000007;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        Long dp[][][] = new Long [m+1][n+1][maxMove+1];

        return (int)findPaths(m,n,maxMove,startRow,startColumn,dp);

    }

    private long findPaths(int m, int n, int maxMove, int startRow, int startColumn,Long [][][] dp) {
        if (maxMove < 0) {
            return 0;
        }
        if (startRow < 0 || startColumn < 0 || startRow == m || startColumn == n) {
            return 1;
        }

        if (dp[startRow][startColumn][maxMove] != null) {
            return dp[startRow][startColumn][maxMove];
        }

        long totalPath =  findPaths(m,n,maxMove-1,startRow-1,startColumn,dp) +
                findPaths(m,n,maxMove-1,startRow,startColumn-1,dp) +
                findPaths(m,n,maxMove-1,startRow+1,startColumn,dp)+
                findPaths(m,n,maxMove-1,startRow,startColumn+1,dp);
        dp[startRow][startColumn][maxMove] = totalPath % mod;
        return dp[startRow][startColumn][maxMove];
    }



    public static void main(String[] args) {
        OutofBoundaryPaths outofBoundaryPaths = new OutofBoundaryPaths();
        System.out.println(outofBoundaryPaths.findPaths(2,2,2,0,0));
    }
}
