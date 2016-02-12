package UVa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bicoloring {
	static ArrayList<Integer> arr[];
	static int[]color;
	static boolean visited[];
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true){
			String line = br.readLine();
			if (line.equals("0"))
				break;
			int n = Integer.parseInt(line);
			int l = Integer.parseInt(br.readLine());
			
			arr = new ArrayList[n];
			for (int i = 0; i < n; i++) 
				arr[i] = new ArrayList<Integer>();
			
			
			for (int i = 0; i < l; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int first = Integer.parseInt(st.nextToken());
				int second = Integer.parseInt(st.nextToken());
				
				arr[first].add(second);
				arr[second].add(first);
			}
			
			color = new int[n];
			Arrays.fill(color, -1);
			visited = new boolean[n];
			
			//BFS
			Queue<Integer> q = new LinkedList<Integer>();
			q.add(0);
			color[0] = 0;
			
			boolean valid = true;
			while(!q.isEmpty() && valid){
				int parent = q.remove();
				visited[parent] = true;
				for (int i = 0; i < arr[parent].size(); i++) {
					int child = arr[parent].get(i);
					if (color[child] == color[parent]){
						valid = false;
						break;
					}
					if (color[child] == -1)
						color[child] = 1 - color[parent];	
					
					if (!visited[child])
						q.add(child);
				}
			}
			
			if (valid)
				System.out.println("BICOLORABLE.");
			else
				System.out.println("NOT BICOLORABLE.");
		}
	}

}
