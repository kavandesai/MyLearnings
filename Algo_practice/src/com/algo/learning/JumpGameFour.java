package com.algo.learning;

import java.util.*;

// Leetcode 1345
public class JumpGameFour {

    public int minJumps(int[] arr) {
        Queue<Integer> elementToVisit = new LinkedList<>();
        Map<Integer, List<Integer>> elementMap = new HashMap<>();
        boolean visited[] = new boolean[arr.length];

        int start = 0;
        int steps = 0;
        for (int i=0;i<arr.length;i++) {
            if (!elementMap.containsKey(arr[i])) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                elementMap.put(arr[i],list);
            } else {
                elementMap.get(arr[i]).add(i);
            }
        }
        elementToVisit.add(start);
        while (elementToVisit.size()>0) {
            int choice = elementToVisit.size();
            while(choice --> 0) {
                int i = elementToVisit.remove();
                if (i == arr.length - 1) {
                    return steps;
                }

                if (i + 1 < arr.length && !visited[i + 1]) {
                    if (i + 1 == arr.length - 1) {
                        steps++;
                        return steps;
                    }
                    elementToVisit.add(i + 1);

                }
                if (i - 1 >= 0 && !visited[i - 1]) {
                    if (i + 1 == arr.length - 1) {
                        steps++;
                        return steps;
                    }
                    elementToVisit.add(i - 1);
                }
                if (elementMap.containsKey(arr[i])) {
                    for (Integer index : elementMap.get(arr[i])) {
                        if (i != index && !visited[i]) {
                            elementToVisit.add(index);
                            if (index == arr.length - 1) {
                                steps++;
                                return steps;
                            }
                        }
                    }
                    elementMap.remove(arr[i]);
                }

                if (i >= 0 && i < arr.length) {
                    visited[i] = true;
                }
            }
            steps++;
        }
        return -1;
    }
    public static void main(String[] args) {
        JumpGameFour jumpGameFour = new JumpGameFour();
        System.out.println(jumpGameFour.minJumps(new int [] {100,-23,-23,404,100,23,23,23,3,404}));
        System.out.println(jumpGameFour.minJumps(new int [] {7}));
        System.out.println(jumpGameFour.minJumps(new int [] {7,6,9,6,9,6,9,7}));

    }
}
