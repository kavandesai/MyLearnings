package com.algo.learning;

import java.util.HashSet;
import java.util.Set;

//Leetcode 695
public class MaxAreaOfIsland {

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        Set<String> visited = new HashSet<>();
        for (int row = 0;row<grid.length;row++)
            for(int column = 0;column<grid[0].length;column++) {
                maxArea = Math.max(maxArea,maxAreaOfIsland(grid,row,column,visited));
            }
        return maxArea;
    }

    private int maxAreaOfIsland(int[][] grid, int row, int column, Set<String> visited) {
        String visit = row+","+column;
        if (row < 0 || row > grid.length-1 || column < 0 || column > grid[0].length -1 || grid[row][column] != 1 || visited.contains(visit)) {
            return 0;
        }
            visited.add(visit);
            return 1 + maxAreaOfIsland(grid,row+1,column,visited)+
                    maxAreaOfIsland(grid,row-1,column,visited)+
                    maxAreaOfIsland(grid,row,column+1,visited)+
                    maxAreaOfIsland(grid,row,column-1,visited);
        }


    public static void main(String[] args) {
        MaxAreaOfIsland maxAreaOfIsland = new MaxAreaOfIsland();
        System.out.println(maxAreaOfIsland.maxAreaOfIsland(new int[][]{{0,0,1,0,0,0,0,1,0,0,0,0,0}, {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}}));
    }
}
