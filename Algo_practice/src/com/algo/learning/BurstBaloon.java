package com.algo.learning;

public class BurstBaloon {


    int maxCoins(int input[]) {
        // create new Array of size n + 2 for original array of size n, to add 1 at first and last index.
        int [] newArray = new int[input.length+2];
        int maxReward = 0;
        newArray[0] = 1;
        newArray[newArray.length-1] = 1;
        for (int i=1;i<newArray.length-1;i++) {
            newArray[i] = input[i-1];
        }
        int a [][] = new int [newArray.length][newArray.length];
        maxReward = maxCoinsEarned(newArray,1,newArray.length-2,a);
        return maxReward;
    }
    int maxCoinsEarned (int[] newArray,int left,int right,int a[][]) {

        if (left > right) {
            return 0;
        } else if (a[left][right] != 0) {
            return a[left][right];
        } else {
                a[left][right] = 0;
                for (int i=left;i<right+1;i++) {
                    int coinsEarned = newArray[left-1] * newArray[right+1] * newArray[i];
                    coinsEarned = coinsEarned + maxCoinsEarned(newArray, left, i - 1, a) +
                            maxCoinsEarned(newArray, i + 1, right, a);
                    a[left][right] = Math.max(coinsEarned,a[left][right]);
                }
                return a[left][right];
            }
        }

        public static void main(String[] args) {
            BurstBaloon s = new BurstBaloon();
            int [] input = {3,1,5,8};
            System.out.println(s.maxCoins(input));
        }
    }


