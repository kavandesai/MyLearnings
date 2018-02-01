package learning;

import java.util.Scanner;

public class Solution {

    static void minimumBribes(int[] q) {
        for (int i=0;i<q.length-1;i++) {
    		if ( (q[i]-1)-i>2 ) {
    			System.out.println("Too chaotic");
    			return;
    		}
    	}
    	int swap = 0;
    	boolean swaped = false;
    	for (int i=0;i<q.length-1;i++) {
    		swaped = false;
    		for (int j=0;j<q.length-i-1;j++) {
    			if (q[j]>q[j+1]) {
    				int temp = q[j+1];
    				q[j+1] = q[j];
    				q[j]= temp;
    				swap++;
    				swaped = true;
    			}
    		}
    		if (!swaped) {
    			break;
    		}
    	}
    	System.out.println(swap);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int[] q = new int[n];
            for(int q_i = 0; q_i < n; q_i++){
                q[q_i] = in.nextInt();
            }
            minimumBribes(q);
        }
        in.close();
    }
}
