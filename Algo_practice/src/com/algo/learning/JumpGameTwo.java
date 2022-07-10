package com.algo.learning;
//Leetcode 45
public class JumpGameTwo {

    public int jump(int[] nums) {
        int left=0,right=0;
        int maxJump = 0;
        int totalSteps =0;
        while(right < nums.length-1) {
            for (int i=left;i<=right;i++) {
                maxJump = Math.max(maxJump,i+nums[i]);
            }
            left = right+1;
            right = maxJump;
            totalSteps = totalSteps+1;
        }
        return totalSteps;
    }
    public static void main(String[] args) {
        JumpGameTwo jumpGame = new JumpGameTwo();
        System.out.println(jumpGame.jump(new int [] {2,3,1,1,4}));
        System.out.println(jumpGame.jump(new int [] {2,3,0,1,4}));
    }
}
