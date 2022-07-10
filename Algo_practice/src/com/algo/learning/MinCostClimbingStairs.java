package com.algo.learning;

import java.util.*;
import java.util.stream.Collectors;

//Leetcode 746
public class MinCostClimbingStairs {


    public int minCostClimbingStairs(int[] cost) {
        List<Integer> costList = Arrays.stream(cost).boxed().collect(Collectors.toList());
        costList.add(0);
        for (int i=costList.size()-3;i>=0;i--) {//starting with 2nd last index
            costList.set(i,cost[i] + Math.min(costList.get(i+1),costList.get(i+2)));
        }
        return Math.min(costList.get(0),costList.get(1));
    }

    public static void main(String[] args) {
        MinCostClimbingStairs minCostClimbingStairs = new MinCostClimbingStairs();
        System.out.println(minCostClimbingStairs.minCostClimbingStairs(new int [] {1,100,1,1,1,100,1,1,100,1}));
        System.out.println(minCostClimbingStairs.minCostClimbingStairs(new int [] {10,15,20}));
        System.out.println(minCostClimbingStairs.minCostClimbingStairs(new int [] {0,1,0,0}));

    }
}
