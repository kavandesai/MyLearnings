package com.algo.learning;


import java.util.*;

public class MaximalRectangle {
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
        Deque<MaximalRectangle.Pair<Integer,Integer>> stack = new LinkedList<>();
        for (int i=0;i<heights.length;i++) {
            if (stack.isEmpty() || stack.peekFirst().height <= heights[i]) {
                stack.push(new MaximalRectangle.Pair(i, heights[i]));
            } else {
                int indexToInsert = i;
                while(!stack.isEmpty() && stack.peekFirst().height > heights[i]) {
                    MaximalRectangle.Pair<Integer, Integer> p = stack.pop();
                    maxArea = Math.max(maxArea,p.height*(i-p.index));
                    indexToInsert = p.index;
                }
                stack.push(new MaximalRectangle.Pair(indexToInsert,heights[i]));
            }
        }
        while(!stack.isEmpty()) {
            MaximalRectangle.Pair pair = stack.pop();
            maxArea = Math.max(maxArea, pair.height * (heights.length - pair.index));
        }

        return maxArea;
    }

    public int maximalRectangle (char [][] matrix) {
        int [][] matInt = new int[matrix.length][matrix[0].length];
        for (int i=0;i<matrix.length;i++) {
            for(int j=0;j<matrix[0].length;j++) {
                matInt[i][j] = matrix[i][j] - '0';
            }
        }
        return maximalRectangle(matInt);
    }

    public int maximalRectangle(int[][] matrix) {
        int maxArea = 0;
        int temp [] = new int[matrix[0].length];
        for (int i=0;i<matrix.length;i++) {
            for (int j=0;j<matrix[0].length;j++) {
                if (matrix[i][j] > 0) {
                    temp[j] = temp[j]+1;
                } else {
                    temp[j] = 0;
                }
            }
            maxArea = Math.max(maxArea,largestRectangleArea(temp));
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int input[][] = {{1,0,1,0,0},
                {1,0,1,1,1},
                {1,1,1,1,1},
                {1,0,0,1,0}};
        MaximalRectangle mrs = new MaximalRectangle();
        Scanner scan = new Scanner(System.in);
        System.out.print("matrix = ");
        String inputStr = scan.next();
        String[] strArray = inputStr.split(",\\[");
        List<String> inputs = new ArrayList<>();
        for (String str: strArray) {
            inputs.add(str.replace("[","").replace("]",""));
        }
        int matrix [][] = new int [inputs.get(0).split(",").length][inputs.size()];
        for (int i=0;i<matrix.length;i++) {
            for (int j=0;j<matrix[0].length;j++) {
                //matrix[i][j] = ;
            }
        }


        int maxRectangle = mrs.maximalRectangle(input);
        System.out.println("Max rectangle is of size " + maxRectangle);
        assert maxRectangle == 8;
    }
}
