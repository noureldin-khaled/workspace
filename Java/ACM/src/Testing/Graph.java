package Testing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Graph {
	static boolean visited[];
	static boolean adjMatrix[][];
	static ArrayList<Integer> adjList[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
		adjMatrix = new boolean[n][n];
		adjList = new ArrayList[n];
		
		for (int i = 0; i < adjList.length; i++) 
			adjList[i] = new ArrayList<Integer>();
		
		
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			adjMatrix[first][second] = true;
			
			adjList[first].add(second);
		}
		
//		for (int i = 0; i < adjMatrix.length; i++) 
//			System.out.println(Arrays.toString(adjMatrix[i]));
		
		for (int i = 0; i < adjList.length; i++) 
			System.out.println(adjList[i]);

//		visited = new boolean[n];
//		
//		dfs(0);
//		System.out.println(Arrays.toString(visited));
		
	}
	
	public static void dfs(int node){
		visited[node] = true;
		
		for (int i = 0; i < adjMatrix[node].length; i++) {
			if (adjMatrix[node][i] && !visited[i])
				dfs(i);
		}
	}

}
