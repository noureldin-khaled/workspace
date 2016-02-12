package Codeforces;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class WetSharkAndBishops {

    public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);

	int n = sc.nextInt();

	char grid[][] = new char[1000][1000];
	for (int i = 0; i < 1000; i++)
	    for (int j = 0; j < 1000; j++)
		grid[i][j] = 'e';

	for (int i = 0; i < n; i++)
	{
	    int x = sc.nextInt() - 1;
	    int y = sc.nextInt() - 1;

	    grid[x][y] = 'b';
	}

	int right[][] = new int[1000][1000];
	int left[][] = new int[1000][1000];

	long ans = 0;
	for (int i = 0; i < 1000; i++)
	{
	    for (int j = 0; j < 1000; j++)
	    {
		if (valid(i-1, j+1))
		    right[i][j] = right[i-1][j+1];
		if (valid(i-1, j-1))
		    left[i][j] = left[i-1][j-1];

		if (grid[i][j] == 'b')
		{
		    if (valid(i-1, j+1))
			ans += right[i-1][j+1];
		    right[i][j]++;
		    if (valid(i-1, j-1))
			ans += left[i-1][j-1];
		    left[i][j]++;
		}
	    }
	}
	
	out.print(ans);

	out.flush();
	out.close();
    }

    static boolean valid(int i, int j)
    {
	return i >= 0 && i < 1000 && j >= 0 && j < 1000;
    }

    static class Scanner {
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
