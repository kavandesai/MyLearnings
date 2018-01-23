package learning;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int[] icecreamParlor(int m, int[] arr) {
    	Map<Integer,List<Integer>> map = populateMap(arr);
    	Arrays.sort(arr);
    	int answer [] = new int [] {0,0};
    	int left = 0,right = arr.length-1;
    	while (left<right) {
    		if ( m-arr[left] == arr[right]) {
    			if (arr[left] == arr[right]) {
    				// Retrieve index from map in special manner
    				answer[0] = (map.get(arr[left]).get(0))+1;
        			answer[1] = (map.get(arr[right]).get(1))+1;
    			} else {
    				answer[0] = (map.get(arr[left]).get(0))+1;
        			answer[1] = (map.get(arr[right]).get(0))+1;
    			}
    			
    			return answer;
    		} else if (m-arr[left] < arr[right]){
    			right--;
    		} else if (m-arr[left] > arr[right]) {
    			left++;
    		}
    			
    	}
    	answer[0] = -1;
    	answer[1] = -1;
    	return answer;
        // Complete this function
    }

    
	private static Map<Integer, List<Integer>> populateMap(int[] arr) {
		Map<Integer,List<Integer>> map = new HashMap<>();
		for (int i=0; i< arr.length;i++) {
			if (map.containsKey(arr[i])) {
				List<Integer> intList = map.get(arr[i]);
				intList.add(i);
				map.put(arr[i], intList);
			} else {
				List<Integer> intList = new ArrayList<>();
				intList.add(i);
				map.put(arr[i], intList);
			}
			
		}
		return map;
	}


	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int finalResult[][] = new int[t][2];
        for(int a0 = 0; a0 < t; a0++){
            int m = in.nextInt();
            int n = in.nextInt();
            int[] arr = new int[n];
            for(int arr_i = 0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
            }
            int[] result = icecreamParlor(m, arr);
            finalResult [a0][0]= result [0];
            finalResult [a0][1]= result [1];
        }
            for (int i = 0; i < t; i++) {
            	if (finalResult[i][0] < finalResult[i][1]) {
            		System.out.print(finalResult[i][0] + " "+ finalResult[i][1]);
            	} else {
            		System.out.print(finalResult[i][1] + " "+ finalResult[i][0]);
            	}
                System.out.println("");
            }
            


        
        in.close();
    }
}
