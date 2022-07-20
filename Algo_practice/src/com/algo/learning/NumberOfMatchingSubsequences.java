package com.algo.learning;

import java.util.*;

// Leetcode 792
public class NumberOfMatchingSubsequences {

    public int numMatchingSubseq(String s, String[] words) {
        int result = 0;
        Map<Character, Queue<String>> charToWords = new HashMap<>();
        for (Character c: s.toCharArray()
             ) {
            charToWords.putIfAbsent(c,new LinkedList<>());
        }

        for (String word : words) {
            if (charToWords.containsKey(word.charAt(0))) {
                charToWords.get(word.charAt(0)).add(word);
            }
        }

        for (int i=0;i<s.length();i++) {
            Queue<String> startSeq = charToWords.get(s.charAt(i));
            int size = startSeq.size();
            for (int j=0;j<size;j++) {
                String str = startSeq.remove();
                if (str.substring(1).length() == 0) {
                    result++;
                } else {
                    if (charToWords.containsKey(str.charAt(1))) {
                        charToWords.get(str.charAt(1)).add(str.substring(1));
                    }
                }
            }
        }

        return result;

    }

    public static void main(String[] args) {

        NumberOfMatchingSubsequences numberOfMatchingSubsequences = new NumberOfMatchingSubsequences();
        System.out.println(numberOfMatchingSubsequences.numMatchingSubseq("abcde",new String [] {"a","bb","acd","ace"}));

    }
}
