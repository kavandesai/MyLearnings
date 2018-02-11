package learning;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

class Element {
	private int parent;
	private int value;
	private boolean isRoot;
	private int size;
	private int rank;
	
	
	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getParent() {
		return parent;
	}

	public void setParent(int parent) {
		this.parent = parent;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public boolean isRoot() {
		return isRoot;
	}

	public void setRoot(boolean isRoot) {
		this.isRoot = isRoot;
	}

	
	
	public Element (int parent, int value, boolean isRoot, int size,int rank) {
		this.parent = parent;
		this.value = value;
		this.isRoot = isRoot;
		this.size = size;
		this.rank = rank;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	
}
class DisjonitSet {
	static Map<Integer,Element> elementMap = new HashMap<>();
	static int min,max = 0;
	static boolean b = true;
	public static  void add(int ele) {
		
		if (!elementMap.containsKey(ele)) {
			Element element = new Element(ele, ele, true,1,0);
			elementMap.put(ele, element); 
		}
	}
	
	public static void unionSet(int ele1,int ele2) {
		Element element1 = elementMap.get(ele1);
		Element element2 = elementMap.get(ele2);
		while (!element2.isRoot()) {
			element2 = Root(element2);
		}

		if (!element1.isRoot()) {
			element1 = Root(element1);
		}
		
		if (element1.getRank() > element2.getRank()) {
			element2.setParent(element1.getValue());
			element2.setRoot(false);
			element1.setSize(element1.getSize()+element2.getSize());
			element1.setRank(element1.getRank()+1);
		} else if (element1.getRank() < element2.getRank()) {
			element1.setParent(element2.getValue());
			element1.setRoot(false);
			element2.setSize(element2.getSize()+element1.getSize());
			element2.setRank(element2.getRank()+1);
		} else if (element1.getRank() == element2.getRank() && element1.getParent() == element2.getParent()) {
			// do nothing both are of same root
			} else {
				element1.setParent(element2.getValue());
				element1.setRoot(false);
				element2.setSize(element2.getSize()+element1.getSize());
				element2.setRank(element2.getRank()+1);
		}
		
		if (b) {
			max = element1.getSize();
			b = false;
		}
		
		if (element1.isRoot() && element1.getSize() > max) {
			max = element1.getSize();
		}
		
		if (element2.isRoot() && element2.getSize() > max) {
			max = element2.getSize();
		}
		
		
	}
	
	public static void printMinMax() {
		int min = 0;
		int temp = 0;
		boolean isFirst = true;
		Iterator<Integer> i = elementMap.keySet().iterator();
		while (i.hasNext()) {
			temp = i.next();
			Element e = elementMap.get(temp);
			if (e.isRoot()) {
				if (isFirst) {
					isFirst = false;
					min = e.getSize();
				}
				temp = e.getSize();
				if (temp < min) {
					min = temp;
				}
			}
		}
		System.out.println(min+" "+max);
	}
		

	public static Element Root(Element element) {
		Element temp = element;
		while (!temp.isRoot()) {
			temp = elementMap.get(temp.getParent());
		}
		element.setParent(temp.getValue());
		return temp;
	}
	
}

public class Solution {

	public static void main (String args[]) {
		Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        for(int ele_i = 0; ele_i < N; ele_i++) {
          	DisjonitSet.add(ele_i+1);
        }
        
        int Q = in.nextInt();
        in.nextLine();
        String keys[] = new String[Q];
        for (int i=0;i<Q;i++) {
        	String key = in.nextLine();
        	keys[i] = key;
        }
        
        for(String str : keys){
        	if (str.startsWith("M")) {
        		String arr[] = str.split(" ");
        		DisjonitSet.unionSet(Integer.parseInt(arr[1]),Integer.parseInt(arr[2]));
        	} else {
        		String arr[] = str.split(" ");
        		Element root = DisjonitSet.Root(DisjonitSet.elementMap.get(Integer.parseInt(arr[1])));
        		System.out.println(root.getSize());
        	}
             
          }
          
            
            
            in.close();
		
	}

}
