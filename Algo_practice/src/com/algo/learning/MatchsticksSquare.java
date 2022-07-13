package com.algo.learning;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//Leetcode 473
public class MatchsticksSquare {

    public boolean makesquare(int[] matchsticks) {
        int total = Arrays.stream(matchsticks).sum();
        int side = total/4;
        double exactSide = total/4;
        if (exactSide-side>0) {
            return false;
        }
        int[] sides = new int[4];
        Arrays.fill(sides,0);
        List<Integer> list = IntStream.of(matchsticks).boxed().collect(Collectors.toList());
        Collections.sort(list,Collections.reverseOrder());
        return backTrack(sides,list.toArray(new Integer[matchsticks.length]),0,side);


    }

    private boolean backTrack(int sides[],Integer[] matchsticks,int current,int sideLength) {
        if (current < matchsticks.length) {
            for (int side = 0; side < 4; side++) {
                if (sides[side] + matchsticks[current] <= sideLength) {
                    sides[side] = sides[side]+matchsticks[current];
                    if (backTrack(sides,matchsticks,current+1,sideLength)) {
                        return true;
                    } else {
                        sides[side] = sides[side]-matchsticks[current]; // back track since combination doesn't work
                    }

                }
            }
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        MatchsticksSquare matchsticksSquare = new MatchsticksSquare();
        System.out.println(matchsticksSquare.makesquare(new int[] {1,1,2,2,2}));
        System.out.println(matchsticksSquare.makesquare(new int[] {3,3,3,3,4}));
    }
}
