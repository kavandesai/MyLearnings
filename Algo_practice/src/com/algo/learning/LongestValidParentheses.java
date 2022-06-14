package com.algo.learning;

import java.util.*;

class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int left = 0;
        int right = 0;
        int maxValidLength =0;
        char [] chars = s.toCharArray();
        //left to right
        for (int i=0;i<s.toCharArray().length;i++) {
            if (chars[i] == '(') {
                left++;
            } else {
                right++;
            }
            if (right > left) {
                left = right = 0;
            }
            if (left == right) {
                maxValidLength = Math.max(maxValidLength,2*left);
            }

        }
        //right to left
        left = right = 0;
        for (int i=s.toCharArray().length-1;i>=0;i--) {
            if (chars[i] == '(') {
                left++;
            } else {
                right++;
            }
            if (left > right) {
                left = right = 0;
            }
            if (left == right) {
                maxValidLength = Math.max(maxValidLength,2*left);
            }
        }
        return maxValidLength;

    }
        public static void main (String[]args){
            LongestValidParentheses s = new LongestValidParentheses();
            Scanner scan = new Scanner(System.in);
            System.out.print("s =");
            String input = scan.next();
            System.out.println(s.longestValidParentheses(input));
        }
    }
