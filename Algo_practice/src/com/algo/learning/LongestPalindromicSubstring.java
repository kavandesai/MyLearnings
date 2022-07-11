package com.algo.learning;
// Leedcode 5
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        String palindrom = new String();
        for (int i=0;i<s.length();i++){
            //odd palindrom
            int left=i,right=i;
            while (left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)) {
                if (right-left+1>palindrom.length()) {
                    palindrom = s.substring(left,right+1);
                }
                left--;
                right++;
            }
            //even palindrom
            left=i;
            right=i+1;
            while (left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)) {
                if (right-left+1>palindrom.length()) {
                    palindrom = s.substring(left,right+1);
                }
                left--;
                right++;
            }

    }
        return palindrom;
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
        System.out.println(longestPalindromicSubstring.longestPalindrome("babad"));
        System.out.println(longestPalindromicSubstring.longestPalindrome("cbbd"));

    }
}
