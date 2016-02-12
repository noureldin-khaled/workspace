package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class Maze {
	static int dist;
	static int arr[][];
	static int targetX;
	static int targetY;
	static int dx[] = {-1,0,1, 0};
	static int dy[] = { 0,1,0,-1};
	static int paths;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int n = Integer.parseInt(br.readLine());
		targetX = targetY = n;

		dist = 2*n;
		arr = new int[n+1][n+1];
		boolean [][] visited = new boolean[n+1][n+1];
		paths = 0;

		dfs(0,0,visited,0);
		out.print(paths);
		out.flush();
		out.close();
	}

	public static void dfs(int i, int j, boolean[][] visited,int distTraveled) {
		if (distTraveled == dist && i == targetX && j == targetY){
			paths++;
			System.out.println("no. of paths now is "+paths);
			System.out.println();
		}
		else {
			visited[i][j] = true;
			arr[i][j] = distTraveled;
			System.out.println(i + " " + j);
			System.out.println("distance traveled is "+distTraveled);
			for (int k = 0; k < visited.length; k++) {
				System.out.println(Arrays.toString(visited[k]));
			}
			for (int k = 0; k < arr.length; k++) {
				System.out.println(Arrays.toString(arr[k]));
			}
			System.out.println();
			for (int k = 0; k < 4; k++) {
				int newI = i + dx[k];
				int newJ = j + dy[k];
				System.out.println("I will attempt to go to "+ newI + " " + newJ);

				if (newI >= 0 && newI < arr.length && newJ >= 0 && newJ < arr[newI].length && !visited[newI][newJ])
					dfs(newI, newJ, visited,distTraveled+1);
			}
		}
	}

}
