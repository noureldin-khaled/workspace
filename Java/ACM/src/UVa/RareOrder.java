package UVa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class RareOrder {
	static ArrayList<Integer> arr[];
	static boolean[]visited;
	static Queue<Integer> q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		while(br.ready()){
			ArrayList<String> input = new ArrayList<>();
			while(br.ready()){
				String line = br.readLine();
				if (line.equals("#"))
					break;
				input.add(line);
			}
			
			TreeMap<Character, Integer> tm = new TreeMap<>();
			TreeMap<Integer, Character> tmRev = new TreeMap<Integer, Character>();
			int count = 0;
			for (int i = 0; i < input.size(); i++) {
				String line = input.get(i);
				for (int j = 0; j < line.length(); j++) {
					if (!tmRev.containsValue(line.charAt(j)))
						tmRev.put(count, line.charAt(j));
					if (!tm.containsKey(line.charAt(j)))
						tm.put(line.charAt(j), count++);
				}
			}
			
			int size = tm.size();
			arr = new ArrayList[size];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = new ArrayList<>();
			}
			String first = input.get(0);
			for (int i = 1; i < input.size(); i++) {
				String second = input.get(i);
				
				if (second.length() < first.length()){
					for (int j = 0; j < second.length(); j++) {
						if (first.charAt(j) != second.charAt(j)){
							arr[tm.get(second.charAt(j))].add(tm.get(first.charAt(j)));
							break;
						}
					}
				}
				else {
					for (int j = 0; j < first.length(); j++) {
						if (first.charAt(j) != second.charAt(j)){
							arr[tm.get(second.charAt(j))].add(tm.get(first.charAt(j)));
							break;
						}
					}
				}
				
				first = input.get(i);
			}
			
			visited = new boolean[size];
			q = new LinkedList<Integer>();
			for (int i = 0; i < visited.length; i++) {
				if (!visited[i])
					dfs(i);
			}
			
			while(!q.isEmpty()){
				int e = q.remove();
				out.print(tmRev.get(e));
			}
			out.println();
		}
		out.flush();
		out.close();
	}

	public static void dfs(int node) {
		visited[node] = true;
		
		for (int i = 0; i < arr[node].size(); i++) {
			int dist = arr[node].get(i);
			if (!visited[dist])
				dfs(dist);
		}
		
		q.add(node);
	}

}
