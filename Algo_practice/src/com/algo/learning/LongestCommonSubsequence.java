package com.algo.learning;

public class LongestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {
        int [][] a = new int[text1.length()+1][text2.length()+2];

        for (int i=text1.length()-1;i>=0;i--) {
            for (int j=text2.length()-1;j>=0;j--) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    a[i][j] =1+ a[i+1][j+1];
                } else {
                    a[i][j] = Math.max(a[i][j+1],a[i+1][j]);
                }
            }
        }
        return a[0][0];
    }

    public static void main(String[] args) {
        LongestCommonSubsequence sol = new LongestCommonSubsequence();
        System.out.println(sol.longestCommonSubsequence("abc","def"));
    }
}
