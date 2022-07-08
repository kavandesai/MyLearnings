package com.algo.learning;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//Leedcode 55
public class JumpGame {


    public boolean canJump(int [] nums) {
        int target = nums.length-1;
            for (int i=target;i>=0;i--) {
                if (i+nums[i] >= target) {
                    target = i;
                }
            }
            return target == 0;
        }

    public static void main(String[] args) {

        JumpGame jumpGame = new JumpGame();
        System.out.println(jumpGame.canJump(new int [] {1}));//true
        System.out.println(jumpGame.canJump(new int [] {0}));//true
        System.out.println(jumpGame.canJump(new int[] {2,3,1,1,4}));//true
        System.out.println(jumpGame.canJump(new int [] {3,2,1,0,4}));//false
        System.out.println(jumpGame.canJump(new int [] {0,2,3}));//false
        System.out.println(jumpGame.canJump(new int [] {1,2,3}));//true
        System.out.println(jumpGame.canJump(new int [] {2,0,0}));//false


    }
}
