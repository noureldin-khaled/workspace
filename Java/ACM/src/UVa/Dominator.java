package UVa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Dominator {
	static int[][]arr;
	static boolean[]visited;
	static boolean[][]domination;
	static int removedNode;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for (int g = 1; g <= t; g++){
			int N = Integer.parseInt(br.readLine());
			
			arr = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) 
					arr[i][j] = Integer.parseInt(st.nextToken());
			}
			removedNode = -1;
			visited = new boolean[N];
			dfs(0);
			domination = new boolean[N][N];
			for (int i = 0; i < visited.length; i++) {
				if (visited[i])
					domination[0][i] = true;
			}
			boolean temp[] = new boolean[N];
			for (int i = 0; i < visited.length; i++) 
				temp[i] = visited[i];
			
			for (int i = 0; i < temp.length; i++) {
				visited = new boolean[N];
				if (temp[i]){
					removedNode = i;
					dfs(0);
					for (int j = 0; j < visited.length; j++) {
						if (temp[j] && !visited[j])
							domination[i][j] = true;
					}
				}
			}
			System.out.println("Case " + g + ":");
			int size = 2*N + 1;
			String [] out = new String[size];
			int row = 0;
			for (int i = 0; i < out.length; i++) {
				String line = "";
				if (i%2 == 0){
					for (int j = 0; j < size; j++) {
						if (j == 0 || j == size-1)
							line += "+";
						else
							line += "-";
					}
				}
				else {
					int column = 0;
					for (int j = 0; j < size; j++) {
						if (j%2 == 0)
							line += "|";
						else {
							if (domination[row][column])
								line += "Y";
							else
								line += "N";
							column++;
						}
					}
					row++;
				}
				out[i] = line;
			}
			for (int i = 0; i < out.length; i++) {
				System.out.println(out[i]);
			}
		}
	}
	
	public static void dfs(int node){
		visited[node] = true;
		
		for (int i = 0; i < arr[node].length; i++) {
			if (arr[node][i] == 1 && !visited[i] && i != removedNode)
				dfs(i);
		}
	}

}
