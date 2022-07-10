package com.algo.learning;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class JumpGameSix {

    public int maxResult(int[] nums, int k) {
        Queue<int[]> priorityQueue = new PriorityQueue<>((a,b) -> b[0]-a[0]);
        priorityQueue.offer(new int[]{nums[0],0});
        int max = nums[0];
        for (int i=1;i<nums.length;i++) {
            while(priorityQueue.peek()[1] < i-k) {
                priorityQueue.poll();
                }
            int [] current = priorityQueue.peek();
            max = current[0]+nums[i];
            priorityQueue.offer(new int[]{current[0]+nums[i],i});
        }
        return max;
    }

    public static void main(String[] args) {

        JumpGameSix jumpGameSix = new JumpGameSix();
        System.out.println(jumpGameSix.maxResult(new int[]{1, -1, -2, 4, -7, 3}, 2));
        System.out.println(jumpGameSix.maxResult(new int [] {10,-5,-2,4,0,3},3));
        System.out.println(jumpGameSix.maxResult(new int [] {1,-5,-20,4,-1,3,-6,-3},2));

    }
}
