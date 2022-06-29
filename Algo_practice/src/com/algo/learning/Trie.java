package com.algo.learning;

import java.util.HashMap;
import java.util.Map;

public class Trie {
    private boolean endOfWord = false;
    private Map<Character,Trie> childNodes = new HashMap<>();
    public Trie() {

    }

    public void insert(String word) {
        Trie current = this;
        for (Character c : word.toCharArray()) {
            if (!current.childNodes.containsKey(c)) {
                current.childNodes.put(c,new Trie());
            }
            current = current.childNodes.get(c);
        }
        current.endOfWord=true;

    }

    public boolean search(String word) {
        Trie current = this;
        for (Character c : word.toCharArray()) {
            if (current.childNodes.containsKey(c)) {
                current = current.childNodes.get(c);
            } else {
                return false;
            }

        }
        return current.endOfWord;

    }

    public boolean startsWith(String prefix) {
        Trie current = this;
        for (Character c : prefix.toCharArray()) {
            while (!current.childNodes.containsKey(c)) {
                return false;
            }
            current = current.childNodes.get(c);
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("hello");
        System.out.println(trie.search("hello"));
        System.out.println(trie.search("hell"));
        System.out.println(trie.search("helloa"));
    }
}
