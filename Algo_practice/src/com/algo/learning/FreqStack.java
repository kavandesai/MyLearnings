package com.algo.learning;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
// Leetcode 895
public class FreqStack {
    private int maxFreq;
    private Map<Integer,Integer> elementToFreqMap;
    private Map<Integer, Stack<Integer>> freqToElementStack;

    public FreqStack() {
        maxFreq = 0;
        elementToFreqMap = new HashMap<>();
        freqToElementStack = new HashMap<>();

    }

    public void push(int val) {
        int freq = elementToFreqMap.getOrDefault(val,0);
        elementToFreqMap.put(val,++freq);
        maxFreq = Math.max(freq,maxFreq);
        Stack<Integer> stack = freqToElementStack.getOrDefault(freq,new Stack<>());
        stack.push(val);
        freqToElementStack.put(freq,stack);
    }

    public int pop() {
        if(freqToElementStack.get(maxFreq).empty()) {
            --maxFreq;
        }
            int val = freqToElementStack.get(maxFreq).pop();
            elementToFreqMap.put(val,elementToFreqMap.get(val).intValue()-1);
            return val;
    }

    public static void main(String[] args) {
        FreqStack freqStack = new FreqStack();
        freqStack.push(5); // The stack is [5]
        freqStack.push(7); // The stack is [5,7]
        freqStack.push(5); // The stack is [5,7,5]
        freqStack.push(7); // The stack is [5,7,5,7]
        freqStack.push(4); // The stack is [5,7,5,7,4]
        freqStack.push(5); // The stack is [5,7,5,7,4,5]
        System.out.println(freqStack.pop());   // return 5, as 5 is the most frequent. The stack becomes [5,7,5,7,4].
        System.out.println(freqStack.pop());   // return 7, as 5 and 7 is the most frequent, but 7 is closest to the top. The stack becomes [5,7,5,4].
        System.out.println(freqStack.pop());   // return 5, as 5 is the most frequent. The stack becomes [5,7,4].
        System.out.println(freqStack.pop());   // return 4, as 4, 5 and 7 is the most frequent, but 4 is closest to the top. The stack becomes [5,7].
    }
}
