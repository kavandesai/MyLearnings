package com.algo.learning;

import java.util.*;

public class NonRepeatingSubString {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> sequenceMap = new HashMap<>();
        int subStrLen = 0;
        char sArray [] = s.toCharArray();
        LinkedList<Character> subList = new LinkedList<>();
        for(int i=0;i<sArray.length;i++ ) {
            if (sequenceMap.containsKey(sArray[i])) {
                while (subList.size() >0) {
                    char charToRemove = subList.removeFirst();
                    sequenceMap.remove(charToRemove);
                    if(charToRemove == sArray[i]) {
                        break;
                    }
                }

            }
            sequenceMap.put(sArray[i],i);
            subList.addLast(sArray[i]);
            subStrLen = Math.max(subList.size(), subStrLen);
        }
        return subStrLen;
    }
    public static void main(String[] args) {
        NonRepeatingSubString s = new NonRepeatingSubString();
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter String: ");
        String str  = scan.next();
        System.out.println(s.lengthOfLongestSubstring(str));
    }
}
