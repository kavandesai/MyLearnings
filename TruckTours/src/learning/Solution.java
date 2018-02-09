package learning;

import java.util.Scanner;
class PairNode {
	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public int getPetrol() {
		return petrol;
	}

	public void setPetrol(int petrol) {
		this.petrol = petrol;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public PairNode getNext() {
		return next;
	}

	public void setNext(PairNode next) {
		this.next = next;
	}

	private int distance;
	private int petrol;
	private int index;
	private PairNode next;
	
	public PairNode(int petrol,int distance,int index) {
		this.distance = distance;
		this.petrol = petrol;
		this.index = index;
		this.next = null;
	}
}

class PairQueue {
	
	private PairNode head;
	public PairNode getHead() {
		return head;
	}

	public void setHead(PairNode head) {
		this.head = head;
	}

	private PairNode tail;
	public PairQueue () {
		this.head = null;
		this.tail = null;
	}
	
	public void add(PairNode node) {
		
		if (this.head == null ) {
			this.head = node;
			this.tail = node;
		} else {
			this.tail.setNext(node);
			this.tail = this.tail.getNext();
		}
	}
	
	public void addLast(PairNode node) {
			this.tail.setNext(node);
			this.tail = this.tail.getNext();
			this.tail.setNext(this.head);
	}
	
}
public class Solution {
	
	
	static void findMinima(PairQueue queue,int N) {
	PairNode current = 	queue.getHead();
	int count = 0;
	int totalPetrol = 0;
	while (count < N) {
		totalPetrol = totalPetrol + current.getPetrol()-current.getDistance();
		if (totalPetrol < 0) {
			count = 0;
			totalPetrol = 0;
		} else {
			++count;
		}
		current = current.getNext();
	}
	System.out.println(current.getIndex());
	}
	
	public static void main (String args[]) {
		Scanner in = new Scanner(System.in);
		PairQueue pairQueue = new PairQueue();
        int N = in.nextInt();
        int[][] union = new int[N][2];
          for(int ele_i = 0; ele_i < N; ele_i++){
             for(int ele_j = 0; ele_j < 2; ele_j++){
                	union[ele_i][ele_j] = in.nextInt();
                }
             
             PairNode pair = new PairNode(union[ele_i][0], union[ele_i][1],ele_i);
             if (ele_i < N-1) {
            	 pairQueue.add(pair);
             } else {
            	 pairQueue.addLast(pair);
             }
            }
          findMinima(pairQueue,N);
          in.close();
	}

}
