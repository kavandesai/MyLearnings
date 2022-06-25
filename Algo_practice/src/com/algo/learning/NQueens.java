package com.algo.learning;

import java.util.*;

public class NQueens {

    private void backTrack(int r, Set<Integer> col, Set<Integer> negDiag, Set<Integer> posDiag, char[][] chessboard,
                           int n,List<List<String>> results) {
        if (r==n) {
            List<String> list = new ArrayList<>();
            for (char [] a : chessboard) {

                list.add(new String(a));
            }
            results.add(list);
            return;
        }
        for (int c = 0; c < n; c++) {
            if (col.contains(c) || negDiag.contains(r-c) || posDiag.contains(r+c)) {
                continue;
            }

            col.add(c);
            posDiag.add(r+c);
            negDiag.add(r-c);
            chessboard[r][c] = 'Q';
            backTrack(r + 1, col, negDiag, posDiag, chessboard, n,results);
            col.remove(c);
            posDiag.remove(r+c);
            negDiag.remove(r-c);
            chessboard[r][c] = '.';
        }

        }


    public List<List<String>> solveNQueens(int n) {
        char[][] chessboard = new char[n][n];
        Set<Integer> col = new HashSet<>(n);
        Set<Integer> posDiag = new HashSet<>();
        HashSet<Integer> negDiag = new HashSet<>();
        List<List<String>> results = new ArrayList<>();
        for (char c[] : chessboard) {
            Arrays.fill(c,'.');
        }
        backTrack(0, col, negDiag, posDiag, chessboard, n,results);
        return results;
    }

    public static void main(String[] args) {
        NQueens nQueens = new NQueens();
        System.out.println(nQueens.solveNQueens(4));
    }
}
