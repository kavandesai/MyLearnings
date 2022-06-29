package com.algo.learning;

import java.util.Arrays;

// Time complexity O(n) n=> Nth term
// Space complexity O(n) n=> Array of N
public class Fibonacci {

    public static void main(String[] args) {
        int term = 20;
        int cache [] = new int[term];
        Arrays.fill(cache,-1);
        System.out.println(fib(term,cache));
    }

        // Fib = n + n-1 //0,1,1,2,3,5,8
        private static int fib(int term,int[] cache) {
            if (term == 1) {
                cache[term-1] = 0;
                return cache[term-1];
            } else if (term == 2) {
                cache[term-1] = 1;
                return cache[term-1];
            } else if (cache[term-1] != -1) {
                return cache[term-1];
            }
            else {
                cache[term-1] =fib(term-2,cache)+fib(term-1,cache);
                return cache[term-1];
            }
        }

    }
