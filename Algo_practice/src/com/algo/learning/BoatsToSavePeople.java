package com.algo.learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
//Leetcode 881
public class BoatsToSavePeople {

    public int numRescueBoats(int[] people, int limit) {
        int i = 0;
        int j= people.length-1;
        int result = 0;
        List<Integer> listOfPeople = Arrays.stream(people).boxed().sorted().collect(Collectors.toList());
        int remaining = limit;
        while (j>=i) {
            remaining = remaining - listOfPeople.get(j);
            if (remaining >= listOfPeople.get(i)) {
                    i++;

            }
            result++;
            remaining = limit;
            j--;
        }
        return result;
    }

    public static void main(String[] args) {
        BoatsToSavePeople boatsToSavePeople = new BoatsToSavePeople();
        int people[] = {2,49,10,7,11,41,47,2,22,6,13,12,33,18,10,26,2,6,50,10};
        System.out.println(boatsToSavePeople.numRescueBoats(people,50));
    }
}
