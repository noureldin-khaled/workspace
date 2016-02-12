package UVa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Continents {
    static char arr[][];
    static char land;
    static char water;
    static int cur;
    static int M;
    static int N;
    static int dx[] = {1,0,-1,0};
    static int dy[] = {0,1,0,-1}; 
    
    public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter out = new PrintWriter(System.out);
	
	while(br.ready()) {
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    M = Integer.parseInt(st.nextToken());
	    N = Integer.parseInt(st.nextToken());
	    
	    arr = new char[M][N];
	    for (int i = 0; i < M; i++) {
		String line = br.readLine();
		for (int j = 0; j < N; j++) 
		    arr[i][j] = line.charAt(j);
	    }
	    
	    st = new StringTokenizer(br.readLine());
	    int posX = Integer.parseInt(st.nextToken());
	    int posY = Integer.parseInt(st.nextToken());
	    
	    boolean set = false;
	    land = arr[posX][posY];
	    for (int i = 0; i < M; i++) 
		for (int j = 0; j < N; j++) 
		    if (arr[i][j] != land) {
			water = arr[i][j];
			set = true;
			break;
		    }
	    
	    if (!set) {
		out.println(0);
		br.readLine();
		continue;
	    }
	    cur = 0;
	    dfs(posX,posY);
	    
	    int max = 0;
	    for (int i = 0; i < M; i++) {
		for (int j = 0; j < N; j++) {
		    if (arr[i][j] == land) {
			cur = 0;
			dfs(i, j);
			
			max = Math.max(max, cur);
		    }
		}
	    }
	    out.println(max);
	    br.readLine();
	}
	
	out.flush();
	out.close();
    }

    public static void dfs(int i, int j) {
	arr[i][j] = water;
	cur++;
	
	for (int k = 0; k < 4; k++) {
		int newI = i + dx[k];
		int newJ = j + dy[k];
		
		if (newJ >= N)
		    newJ = 0;
		if (newJ < 0)
		    newJ = N-1;
		if (newI >= 0 && newI < M && arr[newI][newJ] == land)
			dfs(newI, newJ);
	}
    }

}
