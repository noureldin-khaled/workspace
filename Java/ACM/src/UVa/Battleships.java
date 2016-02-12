package UVa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Battleships {
    static char arr[][];
    static int N;
    static int dx[] = {1,0,-1,0};
    static int dy[] = {0,1,0,-1}; 

    public static void main(String[] args) throws NumberFormatException, IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter out = new PrintWriter(System.out);

	int T = Integer.parseInt(br.readLine());

	for (int c = 1; c <= T; c++) {
	    N = Integer.parseInt(br.readLine());
	    arr = new char[N][N];

	    for (int i = 0; i < N; i++) {
		String line = br.readLine();
		for (int j = 0; j < N; j++) 
		    arr[i][j] = line.charAt(j);
	    }

	    int ans = 0;
	    for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
		    if (arr[i][j] == 'x') {
			dfs(i,j);
			ans++;
		    }
		}
	    }
	    out.println("Case " + c + ": " + ans);
	}
	out.flush();
	out.close();
    }

    public static void dfs(int i, int j) {
	arr[i][j] = '.';

	for (int k = 0; k < 4; k++) {
	    int newI = i + dx[k];
	    int newJ = j + dy[k];

	    if (newI >= 0 && newI < N && newJ >= 0 && newJ < N && (arr[newI][newJ] == 'x' || arr[newI][newJ] == '@'))
		dfs(newI, newJ);

	}
    }
}
