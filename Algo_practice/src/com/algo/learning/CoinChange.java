package com.algo.learning;

import java.util.Arrays;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int cache [] = new int[amount+1];
        Arrays.fill(cache,amount+1);
        cache[0] = 0;
        for (int i=0;i<=amount;i++) {
            for (int coin : coins) {
                if (i-coin>=0) {
                    cache[i] =Math.min(cache[i], 1+ cache[i-coin]);
                }
            }
        }

        return cache[amount] != (amount+1) ? cache[amount]:-1;
    }
    public static void main(String[] args) {
        CoinChange c = new CoinChange();
        System.out.println(c.coinChange(new int[]{1, 2, 5},11));
    }
}
