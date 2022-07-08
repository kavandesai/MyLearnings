package com.algo.learning;
// Leet code 256
public class PaintHouse {

    public int minCost(int[][] costs) {
        int cost[] = {0,0,0}; // pinting cost of previous house
        for (int i=0;i<cost.length;i++) {
            int cost0 = costs[i][0]+Math.min(cost[1],cost[2]);
            int cost1 = costs[i][1]+Math.min(cost[0],cost[2]);
            int cost2 = costs[i][2]+Math.min(cost[0],cost[1]);
            cost[0] = cost0;
            cost[1] = cost1;
            cost[2] = cost2;
        }
        return Math.min(cost[0],Math.min(cost[1],cost[2]));
    }

    public static void main(String[] args) {
        PaintHouse paintHouse = new PaintHouse();
        System.out.println(paintHouse.minCost(new int [][] {{14,2,11},{11,14,5},{14,3,10}}));
    }
}
