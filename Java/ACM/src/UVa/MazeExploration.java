package UVa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class MazeExploration {
	static ArrayList<ArrayList<Character>> maze;
	static String seperationLine;
	static int dx[] = {-1,0,1, 0};
	static int dy[] = { 0,1,0,-1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
			maze = new ArrayList<>();
			int startX = 0;
			int startY = 0;

			int row = 0;
			while(true){
				String line = br.readLine();
				if (line.contains("_")){
					seperationLine = line;
					break;
				}
				ArrayList<Character> temp = new ArrayList<>();
				for (int i = 0; i < line.length(); i++) {
					char c = line.charAt(i);
					if (c == '*'){
						startX = row;
						startY = i;
					}
					temp.add(c);
				}
				row++;
				maze.add(temp);
			}
			
			dfs(startX,startY);
			
			for (int i = 0; i < maze.size(); i++) {
				for (int j = 0; j < maze.get(i).size(); j++) {
					out.print(maze.get(i).get(j));
				}
				out.println();
			}
			out.println(seperationLine);
		}
		out.flush();
		out.close();
	}

	public static void dfs(int i, int j) {
		maze.get(i).set(j, '#');
		
		for (int k = 0; k < 4; k++) {
			int newI = i + dx[k];
			int newJ = j + dy[k];
			
			if (newI >= 0 && newI < maze.size() && newJ >= 0 && newJ < maze.get(newI).size() && maze.get(newI).get(newJ) == ' ')
				dfs(newI, newJ);
		}
	}

}
