package com.algo.learning;

import java.util.Arrays;

// leetcode 135 - Hard
// 1,0,2
// 1,2,1
public class Candy {
    public int candy(int[] ratings) {
        int [] candies = new int[ratings.length];
        Arrays.fill(candies,1);

        for (int left =1;left<ratings.length;left++) {
            if(ratings[left] > ratings[left-1]) {
                candies[left] = candies[left-1]+1;
            }
        }
        for (int right = ratings.length-2;right>=0;right--) {
            if (ratings[right] > ratings[right+1]) {
                candies[right] = Math.max(candies[right],candies[right+1]+1);
            }
        }

        return Arrays.stream(candies).sum();

    }
    public static void main(String[] args) {
        Candy candy = new Candy();
        //int[] ratings =  {1,2,87,87,87,2,1};//1,2,3,1,3,2,1
        //System.out.println(candy.candy(ratings));
        int [] ratings =  {1,0,2}; //1,1,1
        System.out.println(candy.candy(ratings));

    }
}
