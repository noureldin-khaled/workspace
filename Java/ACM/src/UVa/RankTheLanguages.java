package UVa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Pair implements Comparable<Pair>{
	char first;
	int second;

	public Pair(char first, int second){
		this.first = first;
		this.second = second;
	}

	public String toString(){
		return "("+first+", "+second+")";
	}

	public int compareTo(Pair o) {
		if (this.second > o.second)
			return -1;
		if (this.second < o.second)
			return 1;
		if (this.first > o.first)
			return 1;
		if (this.first < o.first)
			return -1;
		return 0;
	}

	public boolean equals(Object o){
		return this.first == ((Pair) o).first;
	}

}

public class RankTheLanguages {
	static char[][]world;
	static char current;
	static boolean visited[][];
	static int dx[] = {-1,0,1, 0};
	static int dy[] = { 0,1,0,-1};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine());

		for (int i = 1; i <= t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());

			world = new char[H][W];

			for (int j = 0; j < H; j++) {
				String line = br.readLine();
				for (int k = 0; k < W; k++) 
					world[j][k] = line.charAt(k);		
			}

			visited = new boolean[H][W];
			ArrayList<Pair> used = new ArrayList<>();
			for (int j = 0; j < visited.length; j++) {
				for (int j2 = 0; j2 < visited[j].length; j2++) {
					current = world[j][j2];
					if (!visited[j][j2]){
						int index = used.indexOf(new Pair(world[j][j2], 0));
						dfs(j,j2);
						if (index != -1)
							used.get(index).second++;
						else 
							used.add(new Pair(world[j][j2], 1));
					}
				}
			}
			
			Collections.sort(used);
			out.println("World #" + i);
			for (int j = 0; j < used.size(); j++) 
				out.println(used.get(j).first + ": " + used.get(j).second);
		}
		out.flush();
		out.close();
	}

	public static void dfs(int i, int j) {
		visited[i][j] = true;

		for (int k = 0; k < 4; k++) {
			int newI = i + dx[k];
			int newJ = j + dy[k];

			if (newI >= 0 && newI < world.length && newJ >= 0 && newJ < world[newI].length && world[newI][newJ] == current && !visited[newI][newJ])
				dfs(newI, newJ);
		}
	}

}
