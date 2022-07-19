package com.algo.learning;

import java.util.ArrayList;
import java.util.List;
//Leetcode 118
public class PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> results = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        tmp.add(1);
        results.add(tmp);
        for (int i=0;i<numRows-1;i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(0);
            temp.addAll(results.get(i));
            temp.add(0);
            List<Integer> newList = new ArrayList<>(temp.size());
            for (int j=0;j<temp.size()-1;j++) {
                if (j+1 < temp.size()) {
                    newList.add(temp.get(j)+temp.get(j+1));
                }
            }
            results.add(newList);
        }
        return results;
    }

    public static void main(String[] args) {
        PascalsTriangle pascalsTriangle = new PascalsTriangle();
        System.out.println(pascalsTriangle.generate(1));


    }
}
