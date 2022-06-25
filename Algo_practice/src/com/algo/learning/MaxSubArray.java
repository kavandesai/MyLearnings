package com.algo.learning;

public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        int sum=0;
        int j=0;
        int maxSum = nums[0];
        while (j<nums.length) {
            if(sum+nums[j] >= nums[j]) {
                sum = sum + nums[j];
            } else {
                sum = nums[j];
            }
            j++;
            maxSum = Math.max(sum,maxSum);
        }

        return maxSum;
    }
    public static void main(String[] args) {
        MaxSubArray maxSubArray = new MaxSubArray();
        System.out.println(maxSubArray.maxSubArray(new int [] {-2,1,-3,4,-1,2,1,-5,4}));

    }
}
