package learning;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Trie {
	Trie child [] = new Trie[26];
	boolean endOfKey;
	char charAtNode;
	int childCount = 0;
	Trie parent;
	public Trie () {
	}
	
	
	
	
	
 }
public class Solution {
	public static void insert (Trie root,String key) {
		int level = key.length();
		Trie temp = root;
		Trie parent = root;
		for (int i = 0;i<level;i++) {
			if (temp.child[key.charAt(i)-'a'] == null) {
				Trie t = new Trie();
				t.charAtNode = key.charAt(i);
				t.parent = temp;
				temp.child[key.charAt(i)-'a'] = t;
				temp = temp.child[key.charAt(i)-'a'];
			} else {
				temp = temp.child[key.charAt(i)-'a'];
			}
		}
		
		temp.endOfKey = true;
		increamentChildCount(temp);
	}
	
	private static void increamentChildCount(Trie temp) {
		while (temp.parent != null) {
			temp.childCount = temp.childCount + 1;
			temp = temp.parent;
		}
		
	}

	public static int search (Trie root,String key) {
		boolean flage = true;
		for (int i=0;i<key.length();i++) {
			
			if (root != null && root.child[key.charAt(i)-'a'] != null && root.child[key.charAt(i)-'a'].charAtNode == key.charAt(i)) {
				root = root.child[key.charAt(i)-'a'];
			} else {
				flage = false;
			}
		}
		if (flage) {
			return countMatches(root);
		} else {
			return 0;
		}
	}
	
	private static int traverse(int count,Trie currentNode,String key) {
		if (currentNode.endOfKey) {
			++count;
		}
		for (Trie child : currentNode.child) {
			if (child != null) {
				count = traverse(count, child, key+child.charAtNode);
			} 
		}
		
		return count;
	}
	
	public static int countMatches(Trie currentNode,String key) {
		int count = 0;
		if (currentNode.endOfKey) {
			++count;
		}
		for (Trie child : currentNode.child) {
			if (child != null) {
				count = traverse(count, child, key+child.charAtNode);
			}
		}
		
		return count;
	}
	
	public static int countMatches (Trie currentNode) {
		return currentNode.childCount;
	}
	
	public static void main (String args[]) {
		
	Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    in.nextLine();
    String keys[] = new String[n];
    for (int i=0;i<n;i++) {
    	String key = in.nextLine();
    	keys[i] = key;
    }
	in.close();
	 

	 Trie root = new Trie();

	 // Construct trie
	 List<Integer> results = new ArrayList<>();
	 for (String key : keys) {
		 if (key.startsWith("add")) {
			 String [] arr = key.split(" ");
			 String value = arr.length == 2 ? arr[1]: ""; 
			 insert(root,value);
		 } else if (key.startsWith("find")) {
			 String [] arr = key.split(" ");
			 String value = arr.length == 2 ? arr[1]: "";
			 results.add(search(root,value)); 
		 }
	 }
	 
	 for (Integer i : results) {
		 System.out.println(i);
	 }
		 

	 }

}