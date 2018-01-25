package learning;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/*
 * The first line contains a single integer, , denoting the number of queries. The subsequent lines describe each query in the following format:

The first line contains four space-separated integers describing the respective values of n  (the number of cities),m (the number of roads), clib (the cost to build a library), and croad  (the cost to repair a road).
Each line i of the m  subsequent lines contains two space-separated integers,ui  and vi, describing a bidirectional road connecting cities ui and vi.
 */
class CitiesGraph  {
	private int numberOfVertices;
	private Map<Integer,List<Integer>> vertexToEdgeMap;
	
	public Map<Integer, List<Integer>> getVertexToEdgeMap() {
		return vertexToEdgeMap;
	}

	public CitiesGraph(int numberOfVertices) {
		this.numberOfVertices = numberOfVertices;
		vertexToEdgeMap = new HashMap<>(numberOfVertices);
	}
	
	public void addEdge(int vertexV,int vertexW) {
		if (vertexToEdgeMap.containsKey(vertexV)) {
			 List<Integer> adjVertices = vertexToEdgeMap.get(vertexV);
			 adjVertices.add(vertexW);
		} else {
			List<Integer> adjVertices = new ArrayList<>();
			adjVertices.add(vertexW);
			vertexToEdgeMap.put(vertexV, adjVertices);
		}
		if (vertexToEdgeMap.containsKey(vertexW)) {
			 List<Integer> adjVertices = vertexToEdgeMap.get(vertexW);
			 adjVertices.add(vertexV);
		} else {
			List<Integer> adjVertices = new ArrayList<>();
			adjVertices.add(vertexV);
			vertexToEdgeMap.put(vertexW, adjVertices);
		}
		
	}
	
	public long depthFirstSearch(int root,boolean[] visited,long total) {
		visited[root] = true;
		++ total ;
		Iterator<Integer> it = vertexToEdgeMap.get(root).iterator();
		while (it.hasNext()) {
		Integer current = it.next();
			if (!visited[current]) {
				total = depthFirstSearch(current, visited,total);
			}
		}
		return total;
	}
	
}
public class Solution {
	
    static long roadsAndLibraries(int n, int c_lib, int c_road, int[][] cities) {
    	boolean visited [] = new boolean [n+1];
        CitiesGraph cg = new CitiesGraph(n);
        
        long totalCost = 0;
        for (int i =0;i<cities.length;i++) {
        	cg.addEdge(cities[i][0], cities[i][1]);
        }
        if (cg.getVertexToEdgeMap().keySet().size() < n) {
        	for (int i=1;i<=n;i++) {
        		if (!cg.getVertexToEdgeMap().containsKey(i)) {
        			cg.getVertexToEdgeMap().put(i, new ArrayList<Integer>());
        		}
        	}
        }
        for (Integer vertex : cg.getVertexToEdgeMap().keySet()) {
        	long total = 0;
        	if (!visited[vertex]) {
        		total = cg.depthFirstSearch(vertex, visited,total);
        		if (c_lib > c_road) {
        			totalCost += c_lib + ((total-1)* c_road);
        		} else {
        			totalCost += (c_lib * total); 
        		}
        	}
        }
    	return totalCost;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int n = in.nextInt();
            int m = in.nextInt();
            int c_lib = in.nextInt();
            int c_road = in.nextInt();
            int[][] cities = new int[m][2];
            for(int cities_i = 0; cities_i < m; cities_i++){
                for(int cities_j = 0; cities_j < 2; cities_j++){
                    cities[cities_i][cities_j] = in.nextInt();
                }
            }
            long result = roadsAndLibraries(n, c_lib, c_road, cities);
            System.out.println(result);
        }
        in.close();
    }
}
