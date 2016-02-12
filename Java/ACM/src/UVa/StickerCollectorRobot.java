package UVa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class StickerCollectorRobot {
					  //U,R,D, L
	static int dx[] = {-1,0,1, 0};
	static int dy[] = { 0,1,0,-1};
	static char arr[][];
	static String instructions;
	static int direction;
	static int count;
	static int index;
	static int S;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true){
			String line = br.readLine();
			if (line.equals("0 0 0"))
				break;
			StringTokenizer st = new StringTokenizer(line);
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			S = Integer.parseInt(st.nextToken());
			
			arr = new char[N][M];
			
			int startX = 0;
			int startY = 0;
			for (int i = 0; i < N; i++) {
				String row = br.readLine();
				for (int j = 0; j < M; j++) {
					if (row.charAt(j) == 'N'){
						startX = i;
						startY = j;
						direction = 0;
					}
					if (row.charAt(j) == 'S'){
						startX = i;
						startY = j;
						direction = 2;
					}
					if (row.charAt(j) == 'L'){
						startX = i;
						startY = j;
						direction = 1;
					}
					if (row.charAt(j) == 'O'){
						startX = i;
						startY = j;
						direction = 3;
					}
					arr[i][j] = row.charAt(j);
				}
			}
			
			instructions = br.readLine();
			index = 0;
			count = 0;
			traverse(startX, startY);
			System.out.println(count);
		}
	}
	
	public static void traverse(int x,int y){
		for (; index < S; index++) {
			char c = instructions.charAt(index);
			if (c == 'D'){
				direction++;
				if (direction == 4)
					direction = 0;
			}
			else if (c == 'E'){
				direction--;
				if (direction == -1)
					direction = 3;
			}
			else { // c == 'F'
				int newX = x + dx[direction];
				int newY = y + dy[direction];
				if (newX >= 0 && newX < arr.length && newY >= 0 && newY < arr[newX].length && arr[newX][newY] != '#'){
					if (arr[newX][newY] == '*')
						count++;
					arr[newX][newY] = '.';
					index++;
					traverse(newX, newY);
					break;
				}
			}
		}
	}
}











