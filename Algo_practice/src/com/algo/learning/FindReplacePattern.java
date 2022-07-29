package com.algo.learning;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Leetcode 890
public class FindReplacePattern {

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        String normalizedPattern = normalize(pattern);
        List<String> results = new ArrayList<>();
        for (String word:words) {
            if (normalize(word).equals(normalizedPattern)) {
                results.add(word);
            }
        }
        return results;
    }

    private String normalize(String pattern) {
        Map<Character,Integer> patternMap = new HashMap<>();
        String normalized = "";
        for(int i=0;i<pattern.length();i++) {
            patternMap.putIfAbsent(pattern.charAt(i),patternMap.size());
            normalized = normalized+patternMap.get(pattern.charAt(i));
        }
        return normalized;
    }
    public static void main(String[] args) {
        String [] words = {"abc","deq","mee","aqq","dkd","ccc"};
        String pattern = "abb";
        FindReplacePattern findReplacePattern = new FindReplacePattern();
        findReplacePattern.findAndReplacePattern(words,pattern).stream().forEach(s -> System.out.println(s));

    }
}
