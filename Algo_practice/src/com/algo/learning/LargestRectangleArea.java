package com.algo.learning;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

class LargestRectangleArea {
    class Pair<I extends Number, I1 extends Number> {
        private Integer index;
        private Integer height;
        public Pair(Integer index,Integer height) {
            this.index = index;
            this.height = height;
        }

    }

    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Deque<Pair<Integer,Integer>> stack = new LinkedList<>();
        for (int i=0;i<heights.length;i++) {
            if (stack.isEmpty() || stack.peekFirst().height <= heights[i]) {
                stack.push(new Pair(i, heights[i]));
            } else {
                int indexToInsert = i;
                while(!stack.isEmpty() && stack.peekFirst().height > heights[i]) {
                    Pair<Integer, Integer> p = stack.pop();
                    maxArea = Math.max(maxArea,p.height*(i-p.index));
                    indexToInsert = p.index;
                }
                stack.push(new Pair(indexToInsert,heights[i]));
            }
        }
        while(!stack.isEmpty()) {
            Pair pair = stack.pop();
            maxArea = Math.max(maxArea, pair.height * (heights.length - pair.index));
        }

        return maxArea;
    }

    public static void main(String[] args) {
        LargestRectangleArea s = new LargestRectangleArea();
        Scanner scan = new Scanner(System.in);
        System.out.print("heights = [");
        String input = scan.next();
        System.out.println("]");
        String strArray[] = input.split(",");
        System.out.println(s.largestRectangleArea(Arrays.stream(strArray).mapToInt(Integer::parseInt).toArray()));
    }
}