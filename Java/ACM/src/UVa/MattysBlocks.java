package UVa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MattysBlocks {

    public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);

	int t = sc.nextInt();
	while(t-->0) {
	    int k = sc.nextInt();
	    int front[] = new int[k];
	    int right[] = new int[k];

	    for (int i = 0; i < k; i++) 
		front[i] = sc.nextInt();

	    for (int i = 0; i < k; i++) 
		right[i] = sc.nextInt();

	    int table[][] = new int[k][k];

	    for (int i = 0; i < k; i++) {
		int elem = front[i];
		for (int j = 0; j < k; j++) 
		    table[j][i] = elem;
	    }

	    for (int i = 0; i < k; i++) {
		int elem = right[k-1-i];
		for (int j = 0; j < k; j++) 
		    if (table[i][j] > elem)
			table[i][j] = elem;
	    }

	    int max_cubes = 0;
	    for (int i = 0; i < k; i++)
		for (int j = 0; j < k; j++) 
		    max_cubes += table[i][j];


	    Arrays.sort(front);
	    Arrays.sort(right);
	    
	    int i = k-1;
	    int j = k-1;
	    int min_cubes = 0;
	    while(i >= 0 && j >= 0) {
		if (front[i] == right[j]) {
		    min_cubes += front[i];
		    i--;
		    j--;
		}
		else if (front[i] < right[j]) {
		    min_cubes += right[j];
		    j--;
		}
		else {
		    min_cubes += front[i];
		    i--;
		}
	    }
	    
	    for (; i >= 0; i--) 
		min_cubes += front[i];
	    
	    for (; j >= 0; j--) 
		min_cubes += right[j];

	    out.printf("Matty needs at least %d blocks, and can add at most %d extra blocks.\n",min_cubes, max_cubes-min_cubes);
	}

	out.flush();
	out.close();
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
	    if (st == null || !st.hasMoreTokens())
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
