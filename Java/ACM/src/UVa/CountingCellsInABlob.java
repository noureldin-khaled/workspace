package UVa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CountingCellsInABlob {
	static int arr[][];
	static boolean [][] visited;
	static int count;
	static int dx[] = {1,0,-1,0,1,1,-1,-1};
	static int dy[] = {0,1,0,-1,1,-1,1,-1};
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		br.readLine();
		while(t-->0){
			ArrayList<String> input = new ArrayList<>();
			while(br.ready()){
				String line = br.readLine();
				if (line.isEmpty())
					break;
				input.add(line);
			}
			int size = input.size();
			arr = new int[size][input.get(0).length()];
			
			for (int i = 0; i < size; i++) {
				String line = input.get(i);
				for (int j = 0; j < line.length(); j++) 
					arr[i][j] = Integer.parseInt(line.charAt(j) + "");
			}
			
			int absoluteMax = 0;
			visited = new boolean[size][input.get(0).length()];
			for (int i = 0; i < visited.length; i++) {
				for (int j = 0; j < visited[i].length; j++) {
					if (!visited[i][j] && arr[i][j] == 1){
						count = 0;
						dfs(i,j);
						if (count > absoluteMax)
							absoluteMax = count;
					}
				}
			}

			System.out.println(absoluteMax);
			if (t > 0)
				System.out.println();
		}
		
	}

	public static void dfs(int i, int j) {
		visited[i][j] = true;
		count++;
		for (int k = 0; k < 8; k++) {
			int newI = i + dx[k];
			int newJ = j + dy[k];
			
			if (newI >= 0 && newI < arr.length && newJ >= 0 && newJ < arr[newI].length && arr[newI][newJ] == 1 && !visited[newI][newJ])
				dfs(newI, newJ);
		}
	}

}
