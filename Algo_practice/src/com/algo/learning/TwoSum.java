package com.algo.learning;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> numToIndex = new HashMap<>();

        for (int i=0;i<nums.length;i++) {
            int val = target - nums[i];
            if (numToIndex.containsKey(val)) {
                return new int [] {i,numToIndex.get(val)};
            } else {
                numToIndex.put(nums[i],i);
            }

        }
        return null;
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        System.out.println(Arrays.toString(twoSum.twoSum(new int [] {3,2,4},6)));
    }
}
