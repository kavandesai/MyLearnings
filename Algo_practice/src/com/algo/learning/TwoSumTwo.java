package com.algo.learning;

import java.util.Arrays;

public class TwoSumTwo {

    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length-1;
        while (left < right) {
            if (numbers[left]+numbers[right] > target) {
                right--;
            } else if (numbers[left]+numbers[right] < target) {
                left++;
            } else {
                return new int[] {left+1,right+1};
            }
        }
        return new int[] {};
    }

    public static void main(String[] args) {
        TwoSumTwo twoSumTwo = new TwoSumTwo();
        int [] numbers = {-1,0};
        System.out.println(Arrays.toString(twoSumTwo.twoSum(numbers,-1)));
    }
}
