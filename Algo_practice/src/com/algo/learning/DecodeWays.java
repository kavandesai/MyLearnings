package com.algo.learning;
// Leetcode 91
public class DecodeWays {

    public int numDecodings(String s) {
        int dp [] = new int [s.length()+1];
        dp[s.length()] = 1;
        if(s.charAt(0) == '0') {
            return 0;
        }
        for (int i=s.length()-1;i>=0;i--) {
            if (s.charAt(i) == '0') {
                dp[i] = 0;
            } else {
                dp[i] = dp[i+1];
            }

        if (i+1 < s.length() && Integer.parseInt(s.substring(i,i+1)) >0
                && Integer.parseInt(s.substring(i,i+2)) <= 26) {
            dp[i] = dp[i]+dp[i+2];
            }
        }
        return dp[0];
    }
//268
    public static void main(String[] args) {
        DecodeWays decodeWays = new DecodeWays();
        System.out.println(decodeWays.numDecodings("12"));
        System.out.println(decodeWays.numDecodings("226"));
        System.out.println(decodeWays.numDecodings("06"));
        System.out.println(decodeWays.numDecodings("068"));
        System.out.println(decodeWays.numDecodings("10"));
        System.out.println(decodeWays.numDecodings("1"));
        System.out.println(decodeWays.numDecodings("2060"));

    }
}
