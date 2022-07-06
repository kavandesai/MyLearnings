package com.algo.learning;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class LargestNumber {

    public String largestNumber(int[] nums) {

        List<String> stringOfNums = Arrays.stream(nums).mapToObj(e -> Integer.toString(e)).collect(toList());

        Collections.sort(stringOfNums, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                String temp1 = o1+o2;
                String temp2 = o2+o1;
                return temp2.compareTo(temp1);

            }
        });

        if (stringOfNums.get(0).equals("0")) {
            return "0";
        }
        return String.join("", stringOfNums);
    }


    public static void main(String[] args) {
        LargestNumber largestNumber = new LargestNumber();
        int nums[] = new int[]{0,0};
        System.out.println(largestNumber.largestNumber(nums));

    }
}
