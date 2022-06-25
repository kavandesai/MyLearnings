package com.algo.learning;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> results = new ArrayList<>();
        Map<String,List<String>> anagramGroup = new HashMap<>();
        for (String str: strs) {
            char alphabet[] = new char[26];
            for (char c: str.toCharArray()) {
                alphabet[c-'a']++;
            }
            String key = new String(alphabet);
            anagramGroup.computeIfAbsent(key,k-> new ArrayList<>());
            anagramGroup.get(key).add(str);
        }
         results.addAll(anagramGroup.values());
        return results;
    }

    public static void main(String[] args) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        System.out.println(groupAnagrams.groupAnagrams(new String[] {"eat","tea","tan","ate","nat","bat"}));
    }
}
