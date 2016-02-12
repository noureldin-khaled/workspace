package UVa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Cell{
	int i;
	int j;
	public Cell(int i,int j){
		this.i = i;
		this.j = j;
	}
}
public class MonkeysInARegularForest {
	static char[][]forest;
	static int [][]res;
	static int count;
	static int [] spaces;
	static int dx[] = {1,0,-1,0,1,1,-1,-1};
	static int dy[] = {0,1,0,-1,1,-1,1,-1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while(br.ready()){
				ArrayList<String> input = new ArrayList<>();
				while(br.ready()){
					String line = br.readLine();
					if (line.equals("%"))
						break;
					input.add(line);
				}

				int size = input.size();
				int length = input.get(0).length()/2 + 1;
				forest = new char[size][length];

				for (int i = 0; i < size; i++) {
					StringTokenizer st = new StringTokenizer(input.get(i));
					for (int j = 0; j < length; j++) 
						forest[i][j] = st.nextToken().charAt(0);
				}

				res = new int[size][length];
				count = 1;
				for (int i = 0; i < res.length; i++) {
					for (int j = 0; j < res[i].length; j++) {
						if (res[i][j] == 0){
							dfs(i, j);
							count++;
						}
					}
				}
			
			int columnLength = res[0].length;
			spaces = new int[columnLength];
			for (int j = 0; j < columnLength; j++) {
				int max = 0;
				for (int i = 0; i < res.length; i++) {
					if (res[i][j] > max)
						max = res[i][j];
				}
				spaces[j] = count(max);
			}
			String line = "";
			for (int i = 0; i < res.length; i++) {
				for (int j = 0; j < res[i].length; j++) {
					int spacesNeeded = spaces[j] - count(res[i][j]);
					for (int k = 0; k < spacesNeeded; k++) 
						line += " ";
					if (j == 0)
						line += res[i][j];
					else
						line += " " + res[i][j];
				}
				line += "\n";
			}
			System.out.print(line);
			System.out.println("%");
		}



	}

	public static int count(int num) {
		int result = 0;
		while(num > 0){
			result++;
			num /= 10;
		}
		return result;
	}

	public static void dfs(int i, int j) {
		res[i][j] = count;

		for (int k = 0; k < 8; k++) {
			int newI = i + dx[k];
			int newJ = j + dy[k];

			if (newI >= 0 && newI < forest.length && newJ >= 0 && newJ < forest[newI].length && res[newI][newJ] == 0 && forest[newI][newJ] == forest[i][j])
				dfs(newI, newJ);
		}
	}

}
