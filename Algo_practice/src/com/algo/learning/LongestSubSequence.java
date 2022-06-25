package com.algo.learning;

class LongestSubSequence {
    public int numDistinct(String s, String t) {
        int [][] cache = new int[s.length()+1][t.length()+1];
        return distinctCount(s,t,cache);
    }

    public int distinctCount(String src,String tar,int [][] cache) {

        for(int i=0;i<=src.length();i++) {
            cache[i][tar.length()] = 1;
        }
        for(int i=0;i<tar.length();i++) {
            cache[src.length()][i] = 0;
        }

        for (int s =src.length()-1;s>=0;s--) {
            for (int t=tar.length()-1;t>=0;t--) {
                cache[s][t] = cache[s+1][t];
                if (src.charAt(s) == tar.charAt(t)) {
                    cache[s][t] += cache[s+1][t+1];
                }
            }
        }

        return cache[0][0];
    }

    public static void main(String[] args) {
        LongestSubSequence sol = new LongestSubSequence();
        String s = "rabbbit",
                t = "rabbit";
        System.out.println(sol.numDistinct(s,t));

    }
}
