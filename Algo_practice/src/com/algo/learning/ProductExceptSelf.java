package com.algo.learning;

import java.util.Arrays;

public class ProductExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int[] results = new int[nums.length];
        Arrays.fill(results,1);
        //multiply left sub array till i, left to right
        for (int i=0;i< nums.length;i++) {
            if (i==0) {
                results[i] = 1;
            } else {
                results[i] = nums[i-1]* results[i-1];
            }
        }
        int postfix = 1;
        //multiply right sub array till i, right to left
        for (int i=nums.length-1;i>=0;i--) {
            if (i==nums.length-1) {
                results[i] = results[i]*1;
            } else {
                postfix = postfix*nums[i+1];
                results[i] = results[i]*postfix;
            }
        }
        return results;
    }

    public static void main(String[] args) {
        ProductExceptSelf productExceptSelf = new ProductExceptSelf();
        System.out.println(Arrays.toString(productExceptSelf.productExceptSelf(new int[] {1,2,3,4})));
    }
}
