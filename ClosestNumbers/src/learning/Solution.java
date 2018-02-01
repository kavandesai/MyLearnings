package learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {

    static List<Long> closestNumbers(long[] arr) {
    	List<Long> diffList = new ArrayList<>();
    	Arrays.sort(arr);
    	long previousDiff = -1;
    	if (arr.length >= 2) {
    		previousDiff = arr[1]-arr[0];
    		diffList.add(arr[0]);
    		diffList.add(arr[1]);
    	} else {
    		diffList.add(arr[0]);
    		return diffList;
    	}
    	for (int i = 0;i<arr.length-1;i++) {
    		
    		if (previousDiff >= 0) {
    			if ( previousDiff > (arr[i+1]-arr[i])) {
    				previousDiff = arr[i+1]-arr[i];
    				diffList.clear();
    				diffList.add(arr[i]);
    				diffList.add(arr[i+1]);
    			} else if ( previousDiff == (arr[i+1]-arr[i])) {
    				diffList.add(arr[i]);
    				diffList.add(arr[i+1]);
    			}
    			
    		}
    	}
        return diffList;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] arr = new long[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        List<Long> result = closestNumbers(arr);
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + (i != result.size() - 1 ? " " : ""));
        }
        System.out.println("");


        in.close();
    }
}
