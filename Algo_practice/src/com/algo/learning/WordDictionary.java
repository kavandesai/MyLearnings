package com.algo.learning;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class WordDictionary {
    private boolean endOfWord = false;
    private Map<Character,WordDictionary> childNodes = new HashMap<>();
    private WordDictionary root;

    public WordDictionary() {
        this.childNodes = new HashMap<>();
        this.endOfWord = false;
    }

    public void addWord(String word) {
        WordDictionary current = this;
        for (Character c : word.toCharArray()) {
            if (!current.childNodes.containsKey(c)) {
                current.childNodes.put(c,new WordDictionary());
            }
            current = current.childNodes.get(c);
        }
        current.endOfWord=true;

    }

    public boolean search(String word) {
        WordDictionary current = this;
        return dfs(word,0,current);

    }

    private boolean dfs(String word,int i, WordDictionary current) {
        for (int j=i;j<word.length();j++) {
            if (word.charAt(j) == '.') {
                for (Map.Entry<Character, WordDictionary> entry : current.childNodes.entrySet()) {
                    current = entry.getValue();
                    if (dfs(word, j+1, current)) {  /// a.b.   a->c->b
                        return true;
                    }
                }
                return false;
            } else {
                if (current.childNodes.containsKey(word.charAt(j))) {
                    current = current.childNodes.get(word.charAt(j));

                } else {
                    return false;
                }
            }
        }
        return current.endOfWord;
    }

    public static void main(String[] args) {
        WordDictionary trie = new WordDictionary();
        trie.addWord("and");
        trie.addWord("add");


        //System.out.println(trie.search("a"));
        //System.out.println(trie.search(".at"));*/
        //System.out.println(trie.search("b.d"));
       System.out.println("after add");
        //trie.addWord("b..");
        //System.out.println(trie.search("..t"));
        //System.out.println(trie.search("an."));

        System.out.println(trie.search("a.d."));
        /*System.out.println(trie.search("b."));
        System.out.println(trie.search("a.d"));
        System.out.println(trie.search("."));*/

    }

}
