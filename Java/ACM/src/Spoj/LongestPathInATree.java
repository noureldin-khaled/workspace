package Spoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class LongestPathInATree {
	static ArrayList<Integer> arr[];
	static int dist[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		arr = new ArrayList[N];
		for (int i = 0; i < N; i++) 
			arr[i] = new ArrayList<Integer>();

		for (int i = 0; i < N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken())-1;
			int second = Integer.parseInt(st.nextToken())-1;

			arr[first].add(second);
			arr[second].add(first);
		}
		int index;
		for (index = 0; index < arr.length; index++) {
			if (arr[index].size() == 1)
				break;
		}
		dist = new int[N];
		Arrays.fill(dist, -1);
		
		bfs(index);
		
		int max = 0;
		int maxIndex = 0;
		for (int i = 0; i < dist.length; i++) {
			if (dist[i] > max){
				max = dist[i];
				maxIndex = i;
			}
		}
		
		Arrays.fill(dist, -1);
		
		bfs(maxIndex);
		
		int absouluteMax = 0;
		for (int i = 0; i < dist.length; i++) {
			if (dist[i] > absouluteMax)
				absouluteMax = dist[i];
		}
		
		System.out.println(absouluteMax);
	}

	public static void bfs(int node) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(node);
		dist[node] = 0;

		while(!q.isEmpty()){
			int parent = q.remove();
			for (int i = 0; i < arr[parent].size(); i++) {
				int child = arr[parent].get(i);
				if (dist[child] == -1){
					q.add(child);
					dist[child] = dist[parent] + 1;
				}
			}
		}
	

	}



}
