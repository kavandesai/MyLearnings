package com.algo.learning;

import java.util.HashSet;
import java.util.Set;

public class NQueensTow {
    int total = 0;
    public int totalNQueens(int n) {

        Set<Integer> cols = new HashSet<>();

        Set<Integer> posDiag = new HashSet<>();
        Set<Integer> negDiag = new HashSet<>();
        return backTrack(n,0,cols,posDiag,negDiag);

    }

    private int backTrack(int n, int row, Set<Integer> cols, Set<Integer> posDiag, Set<Integer> negDiag) {
        if (row == n) {
            total = total+1;
            return total;
        }
        for (int col =0;col<n;col++) {
            if (cols.contains(col) || posDiag.contains(col+row) || negDiag.contains(col-row)) {
                continue;
            }
            cols.add(col);
            posDiag.add(col+row);
            negDiag.add(col-row);
            backTrack(n,row+1,cols,posDiag,negDiag);
            cols.remove(col);
            posDiag.remove(col+row);
            negDiag.remove(col-row);
        }
        return total;
    }

    public static void main(String[] args) {
        NQueensTow nQueensTow = new NQueensTow();
        System.out.println(nQueensTow.totalNQueens(4));
    }


}
