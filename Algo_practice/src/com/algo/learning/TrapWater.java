package com.algo.learning;

public class TrapWater {
    int trap (int height[]) {
        if (height == null || height.length ==0) {
            return 0;
        }
        int left=0,right=height.length-1,maxLeft = height[0],maxRight = height[height.length-1],totalReserve = 0;
        while (left<right) {
            if (maxLeft<maxRight) {
                left++;
                maxLeft = Math.max(maxLeft,height[left]);
                totalReserve = totalReserve + (maxLeft-height[left]);


            } else {
                right--;
                maxRight = Math.max(maxRight,height[right]);
                totalReserve = totalReserve + (maxRight-height[right]);


            }
        }
        return totalReserve;

    }

    public static void main(String[] args) {
        TrapWater trapWater = new TrapWater();

        System.out.println(trapWater.trap(new int [] {4,2,0,3,2,5}));
    }
}
