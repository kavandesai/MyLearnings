package com.algo.learning;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {

        Set<Integer> numSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int longest = 0;
        int longetSeq = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!numSet.contains(nums[i]-1)) {
                    longest = 0;
                    while (numSet.contains(nums[i] + longest)) {
                        longest = longest + 1;
                    }
                    longetSeq = Math.max(longetSeq, longest);
                }

            }


        return longetSeq;
    }
    public static void main(String[] args) {
        LongestConsecutiveSequence longestConsecutive = new LongestConsecutiveSequence();
        System.out.println(longestConsecutive.longestConsecutive(new int [] {0}));
    }
}
