package com.algo.learning;

import java.util.LinkedList;
import java.util.Queue;

public class JumpGameThree {

    public boolean canReach(int[] arr, int start) {
        Queue<Integer> elementsToVisit = new LinkedList<>();
        elementsToVisit.add(start);
        while(elementsToVisit.size()>0) {
            start = elementsToVisit.remove();
            if (arr[start]+start < arr.length ) {
                if (arr[arr[start]+start] == 0) {
                    return true;
                } else if (arr[start + arr[start]] != -1){
                    elementsToVisit.add(arr[start]+start);
                }
            }
            if (start -arr[start] >= 0) {
                if (arr[start- arr[start]] == 0) {
                    return true;
                } else if (arr[start- arr[start]] != -1){
                    elementsToVisit.add(start-arr[start]);
                }
                arr[start] = -1;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        JumpGameThree jumpGameThree = new JumpGameThree();
        System.out.println(jumpGameThree.canReach(new int [] {4,2,3,0,3,1,2},5));
        System.out.println(jumpGameThree.canReach(new int [] {4,2,3,0,3,1,2},0));
        System.out.println(jumpGameThree.canReach(new int [] {3,0,2,1,2},2));
        System.out.println(jumpGameThree.canReach(new int [] {0,1},1));

    }
}
