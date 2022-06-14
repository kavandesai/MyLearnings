package com.algo.learning;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class smallestMissingNumber {
    public int firstMissingPositive(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int smallestMissingNumber = 1;
        for(int num : nums) {
            if (num > 0) {
                if (num == smallestMissingNumber) {
                    smallestMissingNumber++;
                }
                queue.add(num);
            }
        }
        while(queue.peek() != null) {
            if (queue.peek().intValue() > smallestMissingNumber) {
                 return smallestMissingNumber;
            } else {
                smallestMissingNumber = queue.poll()+1;
            }
        }
        return smallestMissingNumber;

    }

    public static void main(String[] args) {
        smallestMissingNumber s = new smallestMissingNumber();
        Scanner scan = new Scanner(System.in);
        System.out.print("nums = [");
        String input = scan.next();
        System.out.println("]");
        String strArray[] = input.split(",");
        System.out.println(s.firstMissingPositive(Arrays.stream(strArray).mapToInt(Integer::parseInt).toArray()));
    }
}
