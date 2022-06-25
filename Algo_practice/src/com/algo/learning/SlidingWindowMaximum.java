package com.algo.learning;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {


public int[] maxSlidingWindow(int[] nums, int k) {
    Deque<Integer> deque = new LinkedList<>();
    int start = 0;
    int end = k-1;
    int i=0;
    int count = 0;
    int result [] = new int[nums.length-k+1];
    while (end < nums.length) {
        while(!deque.isEmpty() && nums[deque.getLast()] < nums[count]) {
            deque.removeLast();
        }
        deque.add(count);
        if (!deque.isEmpty() && deque.getFirst() < start){
            deque.removeFirst();
        }

        if (count>= k-1) {
            result[i] = nums[deque.getFirst()];
            i++;
        }
        if(count >= k-1) {
            start++;
            end++;
        }

        count++;
    }
    return result;
    }

    public static void main(String[] args) {
        SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();
        int nums [] =  {1,3,1,2,0,5};
        int  k = 3;
        System.out.println(Arrays.toString(slidingWindowMaximum.maxSlidingWindow(nums,k)));
    }

}
