package Spoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair{
	int i;
	int j;
	public Pair(int i,int j){
		this.i = i;
		this.j = j;
	}
	
	public String toString(){
		return "(" + i + ", " + j + ")"; 
	}
}

public class Labyrinth {
	static char[][]maze;
	static int[][]dist;
	static int[]dx = {1,0,-1,0};
	static int[]dy = {0,1,0,-1};
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		while(t-->0){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int C = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			
			maze = new char[R][C];
			
			int startX = 0;
			int startY = 0;
			for (int i = 0; i < R; i++) {
				String line = br.readLine();
				for (int j = 0; j < C; j++) {
					char c = line.charAt(j);
					maze[i][j] = c;
					if (c == '.'){
						startX = i;
						startY = j;
					}
				}
			}
			
			dist = new int[R][C];
			for (int i = 0; i < dist.length; i++) 
				Arrays.fill(dist[i], -1);

			bfs(startX,startY);
			
			int max = 0;
			int maxI = 0;
			int maxJ = 0;
			for (int i = 0; i < dist.length; i++) {
				for (int j = 0; j < dist[i].length; j++) {
					if (dist[i][j] > max){
						max = dist[i][j];
						maxI = i;
						maxJ = j;
					}
				}
			}
			
			for (int i = 0; i < dist.length; i++) 
				Arrays.fill(dist[i], -1);
			bfs(maxI,maxJ);
			
			int absoluteMax = 0;
			for (int i = 0; i < dist.length; i++) {
				for (int j = 0; j < dist[i].length; j++) {
					if (dist[i][j] > absoluteMax)
						absoluteMax = dist[i][j];
				}
			}
			
			System.out.println("Maximum rope length is " + absoluteMax + ".");
			
		}
	}

	public static void bfs(int i, int j) {
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(i, j));
		dist[i][j] = 0;
		
		while(!q.isEmpty()){
			Pair parent = q.remove();
			for (int k = 0; k < 4; k++) {
				int newI = parent.i + dx[k];
				int newJ = parent.j + dy[k];
				
				if (newI >= 0 && newI < maze.length && newJ >= 0 && newJ < maze[newI].length && maze[newI][newJ] != '#' && dist[newI][newJ] == -1){
					dist[newI][newJ] = dist[parent.i][parent.j] + 1;
					q.add(new Pair(newI, newJ));
				}
			}
		}
	}

}
