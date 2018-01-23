package learning;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CandiesDistributuin {
	static List<Integer> findMinRankIndex(int arr[]) {
		List<Integer> minRankIndexList = new ArrayList<>();
		int min = arr[0];
		for (int i=0 ; i < arr.length; i++) {
			if (arr[i] < min) {
				min = arr[i];
				minRankIndexList.clear();
				minRankIndexList.add(i);
			} else if (arr[i] == min) {
				minRankIndexList.add(i);
			}
		}
		return minRankIndexList ;
	}
	static int candies(int n, int[] arr) {
		//create array for candies distribution
		int candyDistribution [] = new int[arr.length];
		// populate minIndexs
		List<Integer> minRankIndexList = findMinRankIndex(arr);
		// Distribute candies to students with minimum ranking
		for (int i : minRankIndexList) {
			candyDistribution[i] = 1;
		}
		
		// Distribute candies to remaining students
		// will first cover students having index < minRankIndex
		int indexToBegin = 0;
		for (int minRankIndex : minRankIndexList) {
			 
			for (int i = indexToBegin;i<minRankIndex;i++) {
				if( (arr[i] > arr[minRankIndex]) && ((i+1)<=minRankIndex) &&  (arr[i+1]>arr[i])) {
					if (i == 0 && (candyDistribution[0] == 0)) {
							candyDistribution[i] = 1;
					} else {
						if (candyDistribution[i] == 0) {
							candyDistribution[i] = candyDistribution[i-1] + 1;
						}
					}
					
				} else if ((arr[i] > arr[minRankIndex]) && ((i+1)<=minRankIndex) &&  (arr[i+1]<arr[i])) {
						int temp = i+1;
						while (temp < minRankIndex && arr[temp] < arr[temp-1]) {
							temp++;
						}
						temp --;
						while (temp >= i) {
							if (candyDistribution[temp] == 0 && temp >= 0) {
								if ( temp-1 >=0 && candyDistribution [temp-1] != 0  && candyDistribution[temp+1] != 0 && (candyDistribution [temp-1] - candyDistribution[temp+1] > 0)) {
									candyDistribution[temp] = candyDistribution[temp-1]+1;
								} else {
									candyDistribution[temp] = candyDistribution[temp+1]+1;
								}
								
							}
							temp--;
						}
						
				} else if ((arr[i] > arr[minRankIndex]) && ((i+1)<=minRankIndex) &&  (arr[i+1]==arr[i])) {
					int temp = i+1;
					
					while (temp+1 < minRankIndex && arr[temp] == arr[temp+1]) {
						temp++;
					}
					if ( temp< minRankIndex || ( (temp+1) < minRankIndex && (arr[temp] < arr[temp+1]))) {
					
					int candy = i-1 > 0 ? arr[i-1]>arr[temp]?candyDistribution[i-1]-1 :candyDistribution[i-1]+1 : 2;
					
					while (temp >= i) {
						if (candyDistribution[temp] == 0 && temp-1 > 0 && temp+1 < minRankIndex && arr[temp] == arr[temp-1] && arr[temp] == arr[temp+1]) {
							candyDistribution[temp] = 1;
						} else if (candyDistribution[temp] == 0 && temp-1 < 0 && temp+1 < minRankIndex && arr[temp+1] < arr[temp]) {
							candyDistribution[temp] = candyDistribution[temp+1]+1;
						} else if (candyDistribution[temp] == 0 && temp-1 > 0 && temp+1 >= minRankIndex && arr[temp+1] > arr[temp]) {
							candyDistribution[temp] = candyDistribution[temp+1]-1;
						} else {
							if (candyDistribution[temp] != 0)
							candyDistribution[temp] = candy;
						}
						temp--;
					}
				}
					
					/*int temp = i+1;
					while (temp < minRankIndex && arr[temp] == arr[temp-1]) {
						temp++;
					} 
					temp --;
					if (  arr[temp] < arr[temp+1] && temp+1 < minRankIndex) {
						int candy = i-1 > 0 ? arr[i-1]>arr[temp]?candyDistribution[i-1]-1 :candyDistribution[i-1]+1 : 2;
						while (temp > i) {
							if (candyDistribution[temp] == 0) {
								candyDistribution[temp] = candy;
							}
							temp--;
						}
					} else if (arr[temp] > arr[temp+1] && temp+1 < minRankIndex) {
						
					}*/
					
				}
			}
			indexToBegin = minRankIndex;
		}
		
		for (int i = indexToBegin+1;i<arr.length;i++) {
			if(( (arr[i] > arr[indexToBegin]) && ((i+1)<arr.length) &&  (arr[i+1]>arr[i])) || (i == (arr.length-1) && arr[i-1]<arr[i])) {
					candyDistribution[i] = candyDistribution[i-1] + 1;
					
			} else if ((arr[i] > arr[indexToBegin]) && ((i+1)<arr.length) &&  (arr[i+1]<arr[i])) {
					int temp = i+1;
					while (temp < arr.length && arr[temp] < arr[temp-1]) {
						temp++;
					}
					int candy = 1;
					while (temp > i) {
						if (candyDistribution[temp] == 0) {
							candyDistribution[temp] = candy;
							candy = candy + 1;
						}
						temp--;
					}
					
			} else if ((arr[i] > arr[indexToBegin]) && ((i+1)<arr.length) &&  (arr[i+1]==arr[i])) {
				int temp = i+1;
				while (temp+1 < arr.length && arr[temp] == arr[temp+1]) {
						temp++;
				}
				if ( temp< arr.length || ( (temp+1) < arr.length && (arr[temp] < arr[temp+1]))) {
					
					int candy = i-1 > 0 ? arr[i-1]>arr[temp]?candyDistribution[i-1]-1 :candyDistribution[i-1]+1 : 2;
					
					while (temp >= i) {
						if (candyDistribution[temp] == 0 && temp-1 > 0 && temp+1 < arr.length && arr[temp] == arr[temp-1] && arr[temp] == arr[temp+1]) {
							candyDistribution[temp] = 1;
						} else if (candyDistribution[temp] == 0 && temp-1 < 0 && temp+1 < arr.length && arr[temp] < arr[temp+1]) {
							candyDistribution[temp] = candyDistribution[temp+1]+1;
						} else if (candyDistribution[temp] == 0 && temp-1 > 0 && temp+1 >= arr.length && arr[temp-1] > arr[temp]) {
							candyDistribution[temp] = candyDistribution[temp+1]-1;
						} else {
							candyDistribution[temp] = candy;
						}
						temp--;
					}
				}
				
			}
		}
		
		int candyCount = 0;
		for (int i=0 ;i< candyDistribution.length;i++) {
			candyCount = candyCount + candyDistribution[i];
		}
		return candyCount;
		}
		
		
		
		

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        int result = candies(n, arr);
        System.out.println(result);
        in.close();
    }
}
