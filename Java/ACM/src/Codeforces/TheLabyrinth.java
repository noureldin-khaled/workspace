package Codeforces;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class TheLabyrinth {
    static char grid[][];
    static int colors[][];
    static int size[][];
    static boolean visited[][];
    static int counter;
    static int curColor;
    static int n,m;
    static final int[]dx = {1,-1,0,0};
    static final int[]dy = {0,0,1,-1};


    public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);

	n = sc.nextInt();
	m = sc.nextInt();
	grid = new char[n][m];
	for(int i = 0; i < n; i++) {
	    String line = sc.nextLine();
	    for (int j = 0; j < m; j++) 
		grid[i][j] = line.charAt(j);
	}

	colors = new int[n][m];
	size = new int[n][m];
	visited = new boolean[n][m];

	curColor = 1;
	for (int i = 0; i < n; i++) {
	    for (int j = 0; j < m; j++) {
		if (grid[i][j] != '*' && colors[i][j] == 0) {
		    counter = 0;
		    dfs(i, j);
		    floodfill(i, j);
		    curColor++;
		}
	    }
	}
	
	for (int i = 0; i < n; i++) {
	    for (int j = 0; j < m; j++) {
		if (grid[i][j] == '*') {
		    TreeSet<Integer> ts = new TreeSet<>();
		    int sum = 0;
		    for (int k = 0; k < 4; k++) {
			int newI = i + dx[k];
			int newJ = j + dy[k];

			if (valid(newI, newJ)) {
			    if (!ts.contains(colors[newI][newJ])) {
				sum += size[newI][newJ];
				ts.add(colors[newI][newJ]);
			    }
			}    
		    }
		    
		    out.print(++sum%10);
		}
		else
		    out.print('.');
	    }
	    out.println();
	}

	out.flush();
	out.close();
    }

    private static void dfs(int i, int j) {
	visited[i][j] = true;
	counter++;

	for (int k = 0; k < 4; k++) {
	    int newI = i + dx[k];
	    int newJ = j + dy[k];

	    if (valid(newI, newJ) && !visited[newI][newJ])
		dfs(newI, newJ);
	}
    }

    public static void floodfill(int i, int j) {
	colors[i][j] = curColor;
	size[i][j] = counter;

	for (int k = 0; k < 4; k++) {
	    int newI = i + dx[k];
	    int newJ = j + dy[k];

	    if (valid(newI, newJ) && colors[newI][newJ] == 0)
		floodfill(newI, newJ);
	}
    }

    public static boolean valid(int i, int j) {
	return i >= 0 && i < n && j >= 0 && j < m && grid[i][j] != '*';
    }


    private static class Scanner {
	BufferedReader br;
	StringTokenizer st;

	public Scanner(FileReader f) {
	    br = new BufferedReader(f);
	}

	public Scanner(InputStream in) {
	    br = new BufferedReader(new InputStreamReader(in));
	}

	public String Next() throws IOException {
	    while (st == null || !st.hasMoreTokens())
		st = new StringTokenizer(br.readLine());
	    return st.nextToken();
	}

	public String nextLine() throws IOException {
	    return br.readLine();
	}

	public int nextInt() throws IOException {
	    return Integer.parseInt(Next());
	}

	public long nextLong() throws IOException {
	    return Long.parseLong(Next());
	}

	public double nextDouble() throws IOException {
	    return Double.parseDouble(Next());
	}

	public boolean Ready() throws IOException {
	    return br.ready();
	}

	public void waitForInput(long time) {
	    long ct = System.currentTimeMillis();
	    while(System.currentTimeMillis() - ct < time) {};
	}

    }
}
