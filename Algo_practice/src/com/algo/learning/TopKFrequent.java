package com.algo.learning;

import java.util.*;

public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> numberToFrequency = new HashMap<>();
        Queue<Integer> results = new LinkedList<>();
        for (int i=0;i<nums.length;i++) {
            numberToFrequency.put(nums[i], numberToFrequency.getOrDefault(nums[i], 0) + 1);
        }
        StringBuilder[] stringBuilders = new StringBuilder[nums.length];
        for (Map.Entry<Integer,Integer> entry : numberToFrequency.entrySet()) {
            stringBuilders[entry.getValue()-1] = stringBuilders[entry.getValue()-1]
                    != null ? stringBuilders[entry.getValue()-1].append(",").append(entry.getKey())
                    : new StringBuilder().append(entry.getKey());
        }
        for (int i=nums.length-1;i>=0;i--) {
            if(stringBuilders[i] != null && results.size()<k) {
                String[] strings = stringBuilders[i].toString().split(",");
                for (String str: strings) {
                    results.add(Integer.parseInt(str));
                }
            }
        }
        return results.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        TopKFrequent topKFrequent = new TopKFrequent();
        System.out.println(Arrays.toString(topKFrequent.topKFrequent(new int[] {1,1,1,2,2,3},2)));
    }
}
